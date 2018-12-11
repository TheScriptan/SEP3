package com.bl.persistence;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bl.model.Student;
import com.bl.model.StudentList;

public class PersistenceHandler {
	
	StudentList studentList = new StudentList();
	private Client client;
	private final String baseAddress = "https://localhost:5001/api/";
	
	public PersistenceHandler() {
		//TEMPORARY VARIABLES
		System.setProperty("javax.net.ssl.trustStore", "C:/Program Files/Java/jdk1.8.0_191/jre/lib/security/cacerts");
		
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
	
	public String getAllStudents() {
		WebTarget target = client.target(baseAddress + "students");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	public String getAllEmployees() {
		WebTarget target = client.target(baseAddress + "employees");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	public int addEmployee(String json) {
		WebTarget target = client.target(baseAddress + "employees");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	public int deleteEmployee(int id) {
		WebTarget target = client.target(baseAddress + "employees" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
}
