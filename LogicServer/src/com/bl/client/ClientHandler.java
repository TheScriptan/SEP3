package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;

public class ClientHandler implements Runnable {
	
	final DataInputStream dis;
	final DataOutputStream dos;
	final PersistenceHandler pers;
	Socket s;
	
	boolean isLoggedIn;																	//Boolean to check if user is logged in
	String role;																		//Determines if user is student or employee
	
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, PersistenceHandler pers) {
		this.s = s;
		this.dis = dis;
		this.dos = dos;
		this.isLoggedIn = false;
		this.pers = pers;
	}

	@Override
	public void run() {
		
		String username;
		String password;
		//Login stage
		try{
			username = dis.readUTF();
			password = dis.readUTF();
			isLoggedIn = pers.verifyLogin(username, password, role);					//Check if login credentials are correct
			dos.writeBoolean(isLoggedIn); 												//Send login status to client
			dos.writeUTF(role); 														//Send role for client
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		while(isLoggedIn) {
			StudentHandler studentHandler = new StudentHandler(s, dis, dos, pers); 		//Initializing Student Handler
			EmployeeHandler employeeHandler = new EmployeeHandler(s, dis, dos, pers);	//Initializing Employee Handler
			try{
				String message = dis.readUTF();											//Reading client message JSON
				if(role.equals("student")) {
					studentHandler.acceptMessage(message);										//Accepting client message and making further actions in business logic
				}
				else if(role.equals("employee")){
					employeeHandler.acceptMessage(message);
				}
				else {
					isLoggedIn = false;													//If role is not equal student or employee then exit the loop
				}				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			this.dis.close();
			this.dos.close();
			this.s.close(); 	//MAY NEED TO REMOVE THIS
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
