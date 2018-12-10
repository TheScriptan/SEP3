package com.bl.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.bl.client.ClientHandler;
import com.bl.persistence.PersistenceHandler;

public class Startup {
	
	public static void main(String[] args) {
		
		//Server initialization on port 1234
		try{
			ServerSocket ss = new ServerSocket(1234);
			
			Socket s;
			
			//Running infinite loop
			while(true) {
				s = ss.accept();
				
				System.out.println("New client request received : " + s);
				
				//Obtain input and output streams + PersistenceHandler to reference to ClientHandler and Student/Employee handlers
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				PersistenceHandler pers = new PersistenceHandler();
				
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
