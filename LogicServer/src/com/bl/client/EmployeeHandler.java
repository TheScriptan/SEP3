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
				
				/*
				 * --------------------EMPLOYEE PART----------------- 
				 */
				//GET ALL EMPLOYEES
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_EMPLOYEES.toString())) {
					String json = pers.getAllEmployees();
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No employees found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//GET INDIVIDUAL EMPLOYEE
				if(request.getRequestCode().equals(Utils.Requests.FIND_EMPLOYEE.toString())) {
					String json = pers.getEmployeeById(request.getArguments()[0]);
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No employee found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//ADD EMPLOYEE
				if(request.getRequestCode().equals(Utils.Requests.ADD_EMPLOYEE.toString())) {
					int status = pers.addEmployee(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "" + status);
					} else {
						Utils.SendResponse(dos, "1", "Employee duplicated. Status code: " + status);
					}
				}
				//UPDATE EMPLOYEE
				if(request.getRequestCode().equals(Utils.Requests.EDIT_EMPLOYEE.toString())) {
					int status = pers.updateEmployee(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Updated employee. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to update employee. Status code: " + status);
					}
				}
				//DELETE EMPLOYEE
				if(request.getRequestCode().equals(Utils.Requests.REMOVE_EMPLOYEE.toString())) {
					int status = pers.deleteEmployee(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Deleted employee. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to delete employee. Status code: " + status);
					}
				}
				
				/*
				 * -------------STUDENT PART-------------
				 */
				
				//GET ALL STUDENTS
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_STUDENTS.toString())) {
					String json = pers.getAllStudents();
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No students found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//GET INDIVIDUAL STUDENT
				if(request.getRequestCode().equals(Utils.Requests.FIND_STUDENT.toString())) {
					String json = pers.getStudentById(request.getArguments()[0]);
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No student found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//ADD STUDENT
				if(request.getRequestCode().equals(Utils.Requests.ADD_STUDENT.toString())) {
					int status = pers.addStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "" + status);
					} else {
						Utils.SendResponse(dos, "1", "Student duplicated. Status code: " + status);
					}
				}
				//UPDATE STUDENT
				if(request.getRequestCode().equals(Utils.Requests.EDIT_STUDENT.toString())) {
					int status = pers.updateStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Updated student. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to update student. Status code: " + status);
					}
				}
				//DELETE STUDENT
				if(request.getRequestCode().equals(Utils.Requests.REMOVE_STUDENT.toString())) {
					int status = pers.deleteStudent(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Deleted student. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to delete student. Status code: " + status);
					}
				}
				
				/*
				 * -------------------COMPANY PART
				 */
				//GET ALL COMPANIES
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_COMPANIES.toString())) {
					String json = pers.getAllCompanies();
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No companies found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//GET INDIVIDUAL COMPANY
				if(request.getRequestCode().equals(Utils.Requests.FIND_COMPANY.toString())) {
					String json = pers.getCompanyById(request.getArguments()[0]);
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No company found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//ADD COMPANY
				if(request.getRequestCode().equals(Utils.Requests.ADD_COMPANY.toString())) {
					int status = pers.addCompany(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "" + status);
					} else {
						Utils.SendResponse(dos, "1", "Company duplicated. Status code: " + status);
					}
				}
				//UPDATE COMPANY
				if(request.getRequestCode().equals(Utils.Requests.EDIT_COMPANY.toString())) {
					int status = pers.updateCompany(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Updated company. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to update company. Status code: " + status);
					}
				}
				//DELETE COMPANY
				if(request.getRequestCode().equals(Utils.Requests.REMOVE_COMPANY.toString())) {
					int status = pers.deleteCompany(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Deleted company. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to delete company. Status code: " + status);
					}
				}
				/*
				 * -------------SHIFT PART
				 */
				//GET ALL SHIFTS
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_SHIFTS.toString())) {
					String json = pers.getAllShifts();
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No shifts found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//GET INDIVIDUAL SHIFT
				if(request.getRequestCode().equals(Utils.Requests.FIND_SHIFT.toString())) {
					String json = pers.getShiftById(request.getArguments()[0]);
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No shift found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//ADD SHIFT
				if(request.getRequestCode().equals(Utils.Requests.ADD_SHIFT.toString())) {
					int status = pers.addShift(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "" + status);
					} else {
						Utils.SendResponse(dos, "1", "Shift duplicated. Status code: " + status);
					}
				}
				//UPDATE SHIFT
				if(request.getRequestCode().equals(Utils.Requests.EDIT_SHIFT.toString())) {
					int status = pers.updateShift(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Updated shift. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to update shift. Status code: " + status);
					}
				}
				//DELETE SHIFT
				if(request.getRequestCode().equals(Utils.Requests.REMOVE_SHIFT.toString())) {
					int status = pers.deleteShift(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Deleted shift. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to delete shift. Status code: " + status);
					}
				}
				/*
				 * ------------COMPLETE SHIFT PART
				 */
				//GET ALL COMPLETE SHIFTS
				if(request.getRequestCode().equals(Utils.Requests.FIND_ALL_COMPLETE_SHIFTS.toString())) {
					String json = pers.getAllCompleteShifts();
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No complete shifts found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}
				//GET INDIVIDUAL COMPLETESHIFT
				if(request.getRequestCode().equals(Utils.Requests.FIND_COMPLETE_SHIFT.toString())) {
					String json = pers.getCompleteShiftById(request.getArguments()[0]);
					if(json.equals("-1")) {
						Utils.SendResponse(dos, "1", "No complete shift found");
					} else {
						Utils.SendResponse(dos, "0", json);
					}
				}

				//UPDATE COMPLETESHIFT
				if(request.getRequestCode().equals(Utils.Requests.EDIT_COMPLETE_SHIFT.toString())) {
					int status = pers.updateCompleteShift(request.getArguments()[0]);
					if(status == 200) {
						Utils.SendResponse(dos, "0", "Updated complete shift. Status code: " + status);
					} else {
						Utils.SendResponse(dos, "1", "Failed to update complete shift. Status code: " + status);
					}
				}
			}
				
		}
	}
	
	//Many methods that do actions for message sent by Client and further actions are sent to PersistenceHandler
}
