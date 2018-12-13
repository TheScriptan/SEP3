package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;
import com.bl.utils.Request;
import com.bl.utils.Utils;

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
		Request loginRequest = Utils.AcceptRequest(dis);
		if(loginRequest.getRequestCode().equals(Utils.Requests.LOGIN.toString())) {				//Checking if requestCode == LOGIN
			//Login stage
			try{
				
				username = loginRequest.getArguments()[0];										//Reading 3 inputs username, password and role to verify which DB to check for credentials
				password = loginRequest.getArguments()[1];
				role = loginRequest.getArguments()[2];
				isLoggedIn = pers.verifyLogin(username, password, role);						//Contacting PersistenceHandler to verify login					
				
				
				if(isLoggedIn) {
					Utils.SendResponse(dos, Utils.Responses.LOGIN_VALID, "valid"); 				//Send login status to client
					StudentHandler studentHandler = new StudentHandler(s, dis, dos, pers); 		//Initializing Student Handler
					EmployeeHandler employeeHandler = new EmployeeHandler(s, dis, dos, pers);	//Initializing Employee Handler
					
					if(role.equals("student")) {
						//Send response to client
						studentHandler.Start();
					}
					else if(role.equals("employee")) {
						//Send response to client
						employeeHandler.Start();
					}
					else {
						this.dis.close();
						this.dos.close();
						this.s.close(); 	//MAY NEED TO REMOVE THIS
					}
				} else {
					Utils.SendResponse(dos, Utils.Responses.LOGIN_INVALID, "login invalid"); 			//Send login status to client
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
