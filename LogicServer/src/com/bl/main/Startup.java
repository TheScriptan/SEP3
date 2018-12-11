package com.bl.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.bl.client.ClientHandler;
import com.bl.model.Employee;
import com.bl.persistence.PersistenceHandler;
import com.bl.utils.Utils;

public class Startup {
	
	final static int PORT = 1234;
	
	public static void main(String[] args) {
		
		System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.8.0_191\\jre\\lib\\security");
		//Server initialization on port 1234
		try{
			ServerSocket ss = new ServerSocket(PORT);
			Socket s;
			
			System.out.println("Server started on port " + PORT);
			
			//TESTING
			PersistenceHandler pers = new PersistenceHandler();
			Employee emp = new Employee("220298", "passss", "Ainis", "Frederiksgade", "178905", "gmail@gmail",
					"5573", 55);
			List<Employee> list = new ArrayList<Employee>();
			//pers.addEmployee(Utils.serializeObject(emp));
			String json = pers.getAllEmployees();
			System.out.println(json);
			list = Utils.deserializeList(json, Employee[].class);
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			//Running infinite loop
			while(true) {
				s = ss.accept();
				System.out.println("New client request received : " + s);
				
				//Obtain input and output streams + PersistenceHandler to reference to ClientHandler and Student/Employee handlers
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				//PersistenceHandler pers = new PersistenceHandler();
				
				System.out.println("Creating a new handler for this client..." );
				
				//Create a new handler for this client
				ClientHandler clientHandler = new ClientHandler(s, dis, dos, pers);
				
				//Create a new thread for this client
				Thread t = new Thread(clientHandler);
				
				System.out.println("Adding this client to active client list");
				
				//Start the thread
				t.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
