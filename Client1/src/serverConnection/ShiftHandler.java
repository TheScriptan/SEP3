package serverConnection;


import models.Shift;
import serverConnection.interfaces.IShiftHandler;
import utils.Response;
import utils.Utils;

public class ShiftHandler implements IShiftHandler{

	@Override
	public Response addShift(Connection c, Shift shift) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.ADD_SHIFT, Utils.serializeObject(shift));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response editShift(Connection c, Shift shift) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_SHIFT, Utils.serializeObject(shift));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response removeShift(Connection c, long shiftId) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_SHIFT, shiftId+"");	
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response getAllShifts(Connection c) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.FIND_ALL_SHIFTS, "");
		return Utils.AcceptResponse(c.getInput());
	}

}
