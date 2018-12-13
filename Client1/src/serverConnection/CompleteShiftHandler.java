package serverConnection;


import models.CompleteShift;
import serverConnection.interfaces.ICompleteShiftHandler;
import utils.Response;
import utils.Utils;

public class CompleteShiftHandler implements ICompleteShiftHandler{

	@Override
	public Response addCompleteShift(Connection c, CompleteShift completeShift) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.ADD_SHIFT, Utils.serializeObject(completeShift));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response editCompleteShift(Connection c, CompleteShift completeShift) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_SHIFT, Utils.serializeObject(completeShift));
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response removeCompleteShift(Connection c, long completeShiftId) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.EDIT_SHIFT, completeShiftId+"");	
		return Utils.AcceptResponse(c.getInput());
	}

	@Override
	public Response getAllCompleteShifts(Connection c) {
		Utils.SendRequest(c.getOutput(), Utils.Requests.FIND_ALL_SHIFTS, "");
		return Utils.AcceptResponse(c.getInput());
	}

}
