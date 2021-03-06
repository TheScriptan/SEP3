package com.bl.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.bl.client.ClientHandler;
import com.bl.persistence.PersistenceHandler;

public class Startup {
	
	final static int PORT = 1234;
	
	public static void main(String[] args) {
		
		System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.8.0_191\\jre\\lib\\security");
		//Server initialization on port 1234
		try{
			ServerSocket ss = new ServerSocket(PORT);
			Socket s;
			
			System.out.println("Server started on port " + PORT);
			
			//TESTING PART
			
			//Running infinite loop
			while(true) {
				s = ss.accept();
				System.out.println("New client request received : " + s);
				
				//Obtain input and output streams + PersistenceHandler to reference to ClientHandler and Student/Employee handlers
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				PersistenceHandler pers = new PersistenceHandler();
				
				
				//System.out.println("Creating a new handler for this client..." );
				
				//Create a new handler for this client
				ClientHandler clientHandler = new ClientHandler(s, dis, dos, pers);
				
				//Create a new thread for this client
				Thread t = new Thread(clientHandler);
				
				//System.out.println("Adding this client to active client list");
				
				//Start the thread
				t.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
