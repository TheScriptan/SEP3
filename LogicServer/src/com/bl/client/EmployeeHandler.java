package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;

public class EmployeeHandler extends IHandler {

	public EmployeeHandler(Socket s, DataInputStream dis, DataOutputStream dos, PersistenceHandler pers) {
		super(s, dis, dos, pers);
	}
	
	public void acceptMessage(String message) {
		//if statements to check what message was sent
	}
	
	//Many methods that do actions for message sent by Client and further actions are sent to PersistenceHandler
}
