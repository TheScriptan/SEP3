package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
				//ADD STUDENT
				if(request.getRequestCode().equals(Utils.Requests.ADD_STUDENT.toString())) {
					int status = pers.addStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_ADDED, "" + status);
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_ADDED, "" + status);
					}
				}
					//GET ALL SHIFTS
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_SHIFTS.toString())) {

						String json = pers.getAllShifts();
						if(json.equals("-1")) {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_RETRIEVED, "no shifts");
						} else {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_RETRIEVED, json);
						}
					}
					//GET ALL COMPANIES
					if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_COMPANIES.toString())) {
						String json = pers.getAllCompanies();
						if(json.equals("-1")) {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_RETRIEVED, "no shifts");
						} else {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_RETRIEVED, json);
						}	
					}
					//GET ALL STUDENTS
					if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_STUDENTS.toString())) {
						String json = pers.getAllStudents();
						if(json.equals("-1")) {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_RETRIEVED, "no students");
						} else {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_RETRIEVED, json);
						}	
					}
					//ADD COMPLETE SHIFT
					if(request.getRequestCode().equals(Utils.Requests.ADD_COMPLETE_SHIFT.toString())) {
						int statusx = pers.updateCompleteShift(request.getArguments()[0]);
						if(statusx == 200) {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_ADDED, "" + statusx);
						} else {
							Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_ADDED, "" + statusx);
						}
					}
				}
			}	
		}
	}
	
	//Many methods that do actions for message sent by Client and further actions are sent to PersistenceHandler

