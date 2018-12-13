package serverConnection.interfaces;

import models.CompleteShift;
import serverConnection.Connection;
import utils.Response;

public interface ICompleteShiftHandler {

	public Response addCompleteShift(Connection c, CompleteShift completeShift);
	public Response editCompleteShift(Connection c, CompleteShift completeShift);
	public Response removeCompleteShift(Connection c, long completeShiftId);
	public Response getAllCompleteShifts(Connection c);
}