package com.bl.persistence;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bl.model.Employee;
import com.bl.utils.Utils;

public class PersistenceHandler {
	
	private Client client;
	private final String baseAddress = "https://localhost:5001/api/";
	
	public PersistenceHandler() {
		System.setProperty("javax.net.ssl.trustStore", "C:/Program Files/Java/jdk1.8.0_191/jre/lib/security/cacerts");
		
		client = ClientBuilder.newClient();
	}
	
	//WHEN PERSISTENCE WILL BE FINISHED UPDATE HERE TO RECOGNIZE ROLE
	public boolean verifyLogin(String cpr, String password, String role) {
		if(role.equals("student")) {
			WebTarget target = client.target(baseAddress + "students/" + cpr);
			
			Response response = target.request(MediaType.APPLICATION_JSON).get();
			String json = getEmployeeById(cpr);
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
	
	//GET ALL EMPLOYEEs
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
	
	//PUT ADD EMPLOYEE
	public int addEmployee(String json) {
		WebTarget target = client.target(baseAddress + "employees");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//POST UPDATE EMPLOYEE
	public int updateEmployee(String json) {
		WebTarget target = client.target(baseAddress + "employees");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE EMPLOYEE
	public int deleteEmployee(String id) {
		WebTarget target = client.target(baseAddress + "employees" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
	
	/*
	 * -----------------------STUDENTS--------------------
	 */
	
	//GET ALL STUDENTS
	public String getAllStudents() {
		WebTarget target = client.target(baseAddress + "students");
		Response response = null;
		String json = "";
		
		try{
			response = target.request(MediaType.APPLICATION_JSON).get();
			json = response.readEntity(String.class);
		} catch(javax.ws.rs.InternalServerErrorException e) {
			json = "-1";
		}
		return json;
	}
	
	//GET ONE STUDENT
	
	public String getStudentById(String id) {
		WebTarget target = client.target(baseAddress + "students/" + id);
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
	
	//PUT ADD STUDENT
	public int addStudent(String json) {
		WebTarget target = client.target(baseAddress + "students");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//POST UPDATE STUDENT
	public int updateStudent(String json) {
		WebTarget target = client.target(baseAddress + "students");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE STUDENT
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
	
	//GET ALL COMPANIES
	public String getAllCompanies() {
		WebTarget target = client.target(baseAddress + "companies");
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
	
	//GET ONE COMPANY
	
	public String getCompanyById(String id) {
		WebTarget target = client.target(baseAddress + "companies/" + id);
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
	
	//PUT ADD COMPANY
	public int addCompany(String json) {
		WebTarget target = client.target(baseAddress + "companies");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//POST UPDATE COMPANY
	public int updateCompany(String json) {
		WebTarget target = client.target(baseAddress + "companies");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE COMPANY
	public int deleteCompany(String id) {
		WebTarget target = client.target(baseAddress + "companies" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
		
	/*
	 * -------------------------SHIFTS---------------
	 */
	
	//GET ALL SHIFTS
	public String getAllShifts() {
		WebTarget target = client.target(baseAddress + "shifts");
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
	
	//GET ONE SHIFT
	
	public String getShiftById(String id) {
		WebTarget target = client.target(baseAddress + "shifts/" + id);
		Response response = null;
		String json = "";
		
		try{
			response = target.request(MediaType.APPLICATION_JSON).get();
			json = response.readEntity(String.class);
		} catch(javax.ws.rs.InternalServerErrorException e) {
			json = "-1";
		}
		return json;
	}
	
	//PUT ADD SHIFT
	public int addShift(String json) {
		WebTarget target = client.target(baseAddress + "shifts");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.put(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//POST UPDATE SHIFT
	public int updateShift(String json) {
		WebTarget target = client.target(baseAddress + "shifts");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.accept(MediaType.TEXT_PLAIN_TYPE)
							.post(Entity.json(json));
		int status = response.getStatus();
		return status;
	}
	
	//DELETE SHIFT
	public int deleteShift(String id) {
		WebTarget target = client.target(baseAddress + "shifts" + "/" + id);
		
		Response response = target.request(MediaType.APPLICATION_JSON)
							.delete();
		int status = response.getStatus();
		return status;
	}
	
	/*
	 * --------------------------COMPLETE SHIFT-----------------------
	 */
	
	//GET ALL COMPLETED SHIFTS
	public String getAllCompleteShifts() {
		WebTarget target = client.target(baseAddress + "shiftsdone");
		Response response = null;
		String json = "";
		
		
		try{
			response = target.request(MediaType.APPLICATION_JSON).get();
			json = response.readEntity(String.class);
		} catch(javax.ws.rs.InternalServerErrorException e) {
			json = "-1";
		}
		return json;
	}
	
	//GET ONE COMPLETED SHIFT
	
	public String getCompleteShiftById(String id) {
		WebTarget target = client.target(baseAddress + "shiftsdone/" + id);
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
	
	//POST UPDATE COMPLETESHIFT
		public int updateCompleteShift(String json) {
			WebTarget target = client.target(baseAddress + "shiftsdone");
			
			Response response = target.request(MediaType.APPLICATION_JSON)
								.accept(MediaType.TEXT_PLAIN_TYPE)
								.post(Entity.json(json));
			int status = response.getStatus();
			return status;
		}
	
}
