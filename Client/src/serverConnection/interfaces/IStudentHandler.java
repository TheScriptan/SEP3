package serverConnection.interfaces;

import models.Student;
import serverConnection.Connection;
import utils.Response;

public interface IStudentHandler {

	public Response addStudent(Connection c, Student student);
	public Response editStudent(Connection c, Student student);
	public Response removeStudent(Connection c, String studentId);
	public Response getAllStudents(Connection c);
}