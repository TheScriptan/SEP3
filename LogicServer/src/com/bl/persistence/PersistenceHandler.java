package com.bl.persistence;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bl.model.Employee;
import com.bl.model.Student;
import com.bl.utils.Utils;

public class PersistenceHandler {
	
	private Client client;
	private final String baseAddress = "https://localhost:5001/api/";
	
	public PersistenceHandler() {
		System.setProperty("javax.net.ssl.trustStore", "cacerts");
		
		client = ClientBuilder.newClient();
	}
	
	//WHEN PERSISTENCE WILL BE FINISHED UPDATE HERE TO RECOGNIZE ROLE
	public boolean verifyLogin(String cpr, String password, String role) {
		if(role.equals("student")) {
			String json = getStudentById(cpr);
			if(json.equals("-1")) {															//Checking if json send -1 as an error code
				return false;
			}	
			Student std = (Student) Utils.deserializeObject(json, Student.class);
			if(std.getPassword().equals(password)) {
				return true;
			}
		}
		else if(role.equals("employee")) {
			
			String json = getEmployeeById(cpr);
			if(json.equals("-1")) {															//Checking if json send -1 as an error code
				return false;
			}
				
			Employee emp = (Employee) Utils.deserializeObject(json, Employee.class);
			if(emp.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * -----------------EMPLOYEES----------------------
	 */
	
	//GET ALL
	public String getAllEmployees() {
		WebTarget target = client.target(baseAddress + "employees");
		Response response = null;
		String json = "";
		try {
			response = target.request(MediaType.APPLICATION_JSON).get();
			json = response.readEntity(String.class);
		} catch(javax.ws.rs.InternalServerErrorException e) {
			json = "-1";
		}
				
		return json;
	}
	
	//GET ONE EMPLOYEE
	
	public String getEmployeeById(String cpr) {
		WebTarget target = client.target(baseAddress + "employees/" + cpr);
		String json = "";
		try {
			json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		} catch(javax.ws.rs.InternalServerErrorException e) {
			json = "-1";
		}
		
		return json;
	}
	
	//PUT
	public int addEmployee(String json) {
		WebTarget target = client.target(baseAddress + "employees");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//POST
	public int updateEmployee(String json) {
		WebTarget target = client.target(baseAddress + "employees");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE
	public int deleteEmployee(int id) {
		WebTarget target = client.target(baseAddress + "employees" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
	
	/*
	 * -----------------------STUDENTS--------------------
	 */
	
	//GET ALL
	public String getAllStudents() {
		WebTarget target = client.target(baseAddress + "students");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//GET ONE EMPLOYEE
	
	public String getStudentById(String id) {
		WebTarget target = client.target(baseAddress + "students/" + id);
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//POST
	public int addStudent(String json) {
		WebTarget target = client.target(baseAddress + "students");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//PUT
	public int updateStudent(String json) {
		WebTarget target = client.target(baseAddress + "students");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE
	public int deleteStudent(String id) {
		WebTarget target = client.target(baseAddress + "students" + "/" + id);
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
	
	/*
	 * ---------------------------COMPANY----------
	 */
	
	//GET ALL
	public String getAllCompanies() {
		WebTarget target = client.target(baseAddress + "companies");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//GET ONE EMPLOYEE
	
	public String getCompanyById(int id) {
		WebTarget target = client.target(baseAddress + "companies/" + id);
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//PUT
	public int addCompany(String json) {
		WebTarget target = client.target(baseAddress + "companies");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//POST
	public int updateCompany(String json) {
		WebTarget target = client.target(baseAddress + "companies");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE
	public int deleteCompany(int id) {
		WebTarget target = client.target(baseAddress + "companies" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
		
	/*
	 * -------------------------SHIFTS---------------
	 */
	
	//GET ALL
	public String getAllShifts() {
		WebTarget target = client.target(baseAddress + "shifts");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//GET ONE EMPLOYEE
	
	public String getShiftById(int id) {
		WebTarget target = client.target(baseAddress + "shifts/" + id);
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//POST
	public int addShift(String json) {
		WebTarget target = client.target(baseAddress + "shifts");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//PUT
	public int updateShift(String json) {
		WebTarget target = client.target(baseAddress + "shifts");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE
	public int deleteShift(long id) {
		WebTarget target = client.target(baseAddress + "shifts" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
	
	/*
	 * --------------------------COMPLETE SHIFT-----------------------
	 */
	
	//GET ALL
	public String getAllCompleteShifts() {
		WebTarget target = client.target(baseAddress + "shiftsdone");
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//GET ONE EMPLOYEE
	
	public String getCompleteShiftById(int id) {
		WebTarget target = client.target(baseAddress + "shiftsdone/" + id);
		
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		return json;
	}
	
	//POST
		public int updateCompleteShift(String json) {
			WebTarget target = client.target(baseAddress + "shiftsdone");
			
			Response response = target.request(MediaType.APPLICATION_JSON)
								.accept(MediaType.TEXT_PLAIN_TYPE)
								.post(Entity.json(json));
			int status = response.getStatus();
			return status;
		}
	
}
