package controllers;


import java.util.List;

import models.Student;
import serverConnection.Connection;
import serverConnection.StudentHandler;
import utils.Utils;

public class EmployeeStudentsController {

	StudentHandler sh;
	
	public EmployeeStudentsController() {
		sh = new StudentHandler();
	}
	
	public void deleteStudent(Connection c, String id) {
		
		sh.removeStudent(c, id);
	}
	

	 public List<Student> getAllStudents(Connection c) {
		   return Utils.deserializeList(sh.getAllStudents(c).getArguments()[0], Student[].class);
	   }
}
