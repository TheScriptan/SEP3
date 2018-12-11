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
			username = dis.readUTF();													//Reading 3 inputs username, password and role to verify which DB to check for credentials
			password = dis.readUTF();
			role = dis.readUTF();
			isLoggedIn = pers.verifyLogin(username, password, role);					//Contacting PersistenceHandler to verify login					
			dos.writeBoolean(isLoggedIn); 												//Send login status to client
			
			if(isLoggedIn) {
				StudentHandler studentHandler = new StudentHandler(s, dis, dos, pers); 		//Initializing Student Handler
				EmployeeHandler employeeHandler = new EmployeeHandler(s, dis, dos, pers);	//Initializing Employee Handler
				
				if(role.equals("student")) {
					studentHandler.Start();
				}
				else if(role.equals("employee")) {
					employeeHandler.Start();
				}
				else {
					this.dis.close();
					this.dos.close();
					this.s.close(); 	//MAY NEED TO REMOVE THIS
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
