package serverConnection;

import models.Student;
import serverConnection.interfaces.IStudentsRequestsHandler;
import utils.Response;
import utils.Utils;

public class StudentsRequestsHandler implements IStudentsRequestsHandler{

	@Override
	public Response takeShift(Connection c, Long shiftId) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.TAKE_SHIFT, shiftId+"");
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response register(Connection c, Student student) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.REGISTER, Utils.serializeObject(student));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response checkWorkedHours(Connection c) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.CHECK_WORKED_HOURS, "");
		return Utils.AcceptResponse(c.getInput());
	}

	

	
}
