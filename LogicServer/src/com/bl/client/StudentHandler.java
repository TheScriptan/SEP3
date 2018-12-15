package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;
import com.bl.utils.Request;
import com.bl.utils.Utils;

public class StudentHandler extends IHandler {

	public StudentHandler(Socket s, DataInputStream dis, DataOutputStream dos, PersistenceHandler pers) {
		super(s, dis, dos, pers);
		
	}
	
	public void Start() {
		Request request = null;
		while(!s.isClosed()) {
			request = Utils.AcceptRequest(dis);
			
			if(request != null) {
				
				if(request.getRequestCode().equals(Utils.Requests.TAKE_SHIFT.toString())) {
					
				}
			}
		}
	}
	
	//Many methods that do actions for message sent by Client and further actions are sent to PersistenceHandler
}
