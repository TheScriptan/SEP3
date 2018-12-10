package com.bl.persistence;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.bl.model.Student;
import com.bl.model.StudentList;

public class PersistenceHandler {
	
	StudentList studentList = new StudentList();
	private Client client;
	private final String baseAddress = "http://localhost:5001/api/";
	
	public PersistenceHandler() {
		//TEMPORARY VARIABLES
		Student s1 = new Student((long) 1, "pass", "Ainis", "Amaliegade", 5017, "@gmail.com", "5573", 43.0);
		Student s2 = new Student((long) 2, "pass", "Jonas", "Frederiskgade", 5018, "@gmail.com", "5574", 44.0);
		Student s3 = new Student((long) 3, "pass", "Petras", "Fredericiagade", 5019, "@gmail.com", "5575", 45.0);
		
		studentList.addStudent(s1);
		studentList.addStudent(s2);
		studentList.addStudent(s3);
		
		client = ClientBuilder.newClient();
	}
	
	//WHEN PERSISTENCE WILL BE FINISHED UPDATE HERE TO RECOGNIZE ROLE
	public boolean verifyLogin(String username, String password, String role) {
		if(role.equals("student")) {
			for(int i = 0; i < studentList.size(); i++){
				Student s = studentList.findStudentById(i);
				if(s.getName().equals(username) && s.getPassword().equals(password)) {
					return true;
				}
			}
		}
		else if(role.equals("employee")) {
			
		}
		
		return false;
	}
	
	public String getStudentList() {
		WebTarget target = client.target(baseAddress + "getstudentlist");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	public String getAllEmployees() {
		WebTarget target = client.target(baseAddress + "employees");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(json);
		return json;
	}
}
