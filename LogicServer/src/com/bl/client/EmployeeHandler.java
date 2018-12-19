package com.bl.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.bl.persistence.PersistenceHandler;
import com.bl.utils.Request;
import com.bl.utils.Utils;

public class EmployeeHandler extends IHandler {

	public EmployeeHandler(Socket s, DataInputStream dis, DataOutputStream dos, PersistenceHandler pers) {
		super(s, dis, dos, pers);
	}
	
	public void Start() throws IOException {
		Request request = null;
		
		while(!s.isClosed()) {
			request = Utils.AcceptRequest(dis);
			
			
			if(request != null) {
				
				//GET ALL EMPLOYEES
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_EMPLOYEES.toString())) {
					String json = pers.getAllEmployees();
					if(json.equals("-1")) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_RETRIEVED, "no employees");
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_RETRIEVED, json);
					}
				}
				//GET INDIVIDUAL EMPLOYEE
				if(request.getRequestCode().equals(Utils.Requests.FIND_EMPLOYEE.toString())) {
					String json = pers.getEmployeeById(request.getArguments()[0]);
					if(json.equals("-1")) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_RETRIEVED, "no employee");
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_RETRIEVED, json);
					}
				}
				//ADD EMPLOYEE
				if(request.getRequestCode().equals(Utils.Requests.ADD_EMPLOYEE.toString())) {
					int status = pers.addEmployee(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_ADDED, "" + status);
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_ADDED, "" + status);
					}
				}
				//ADD STUDENT
				if(request.getRequestCode().equals(Utils.Requests.ADD_STUDENT.toString())) {
					int status = pers.addStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_ADDED, "" + status);
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_ADDED, "" + status);
					}
				}
				//ADD SHIFT
				if(request.getRequestCode().equals(Utils.Requests.ADD_SHIFT.toString())) {
					int status = pers.addShift(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_ADDED, "" + status);
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_ADDED, "" + status);
					}
				}
				//gET ALL SHIFTS
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_SHIFTS.toString())) {
					String json = pers.getAllShifts();
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

				//REMOVE STUDENT
				if(request.getRequestCode().equals(Utils.Requests.REMOVE_STUDENT.toString())) {
					int status = pers.deleteStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_DELETED, "" + status);
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_DELETED, "" + status);
					}
				}
				//REMOVE SHIFT
				if(request.getRequestCode().equals(Utils.Requests.REMOVE_SHIFT.toString())) {
					int status = pers.deleteStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_DELETED, "" + status);
					} else {
						Utils.SendResponse(dos, Utils.Responses.OBJECT_NOT_DELETED, "" + status);
					}
				}
			}
				
		}
	}
	
	//Many methods that do actions for message sent by Client and further actions are sent to PersistenceHandler
}
