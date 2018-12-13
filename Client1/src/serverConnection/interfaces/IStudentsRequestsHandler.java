package serverConnection.interfaces;

import models.Student;
import serverConnection.Connection;
import utils.Response;

public interface IStudentsRequestsHandler {

	public Response takeShift(Connection c, Long shiftId);
	public Response register(Connection c, Student student);
	public Response checkWorkedHours(Connection c);
}
