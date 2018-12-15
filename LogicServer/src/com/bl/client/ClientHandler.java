package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;
import com.bl.utils.Request;
import com.bl.utils.Response;
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
		Request initialRequest = Utils.AcceptRequest(dis);
		if(initialRequest.getRequestCode().equals(Utils.Requests.LOGIN.toString())) {				//Checking if requestCode == LOGIN
			//Login stage
			try{
				
				username = initialRequest.getArguments()[0];										//Reading 3 inputs username, password and role to verify which DB to check for credentials
				password = initialRequest.getArguments()[1];
				role = initialRequest.getArguments()[2];
				isLoggedIn = pers.verifyLogin(username, password, role);						//Contacting PersistenceHandler to verify login					
				
				if(isLoggedIn) {
					Utils.SendResponse(dos, "0", "login valid"); 								//Send login status to client
					
					
					
					if(role.equals("student")) {
						//Send response to client
						StudentHandler studentHandler = new StudentHandler(s, dis, dos, pers); 		//Initializing Student Handler
						studentHandler.Start();
					}
					else if(role.equals("employee")) {
						//Send response to client
						EmployeeHandler employeeHandler = new EmployeeHandler(s, dis, dos, pers);	//Initializing Employee Handler
						employeeHandler.Start();
					}
					else {
						this.dis.close();
						this.dos.close();
						this.s.close(); 	//MAY NEED TO REMOVE THIS
					}
				} else {
					Utils.SendResponse(dos, "1", "login invalid"); 			//Send login status to client
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (initialRequest.getRequestCode().equals(Utils.Requests.REGISTER.toString())) {
			try {
				int status = pers.addStudent(initialRequest.getArguments()[0]);
				if(status == 200) {
					Utils.SendResponse(dos, "0", "" + status);
				} else {
					Utils.SendResponse(dos, "1", "Student already exists. Status code: " + status);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
