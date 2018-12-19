package serverConnection;


import java.util.List;

import models.Shift;
import models.Student;
import serverConnection.interfaces.IStudentHandler;
import utils.Response;
import utils.Utils;

public class StudentHandler implements IStudentHandler{

	@Override
	public Response addStudent(Connection c, Student student) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.ADD_STUDENT, Utils.serializeObject(student));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response editStudent(Connection c, Student student) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_STUDENT, Utils.serializeObject(student));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response removeStudent(Connection c, String studentId) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_STUDENT, studentId);	
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response getAllStudents(Connection c) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.FIND_ALL_STUDENTS, "");
		return Utils.AcceptResponse(c.getInput());
	}

}
