package serverConnection.interfaces;

import models.Shift;
import serverConnection.Connection;
import utils.Response;

public interface IShiftHandler {

	public Response addShift(Connection c, Shift shift);
	public Response editShift(Connection c, Shift shift);
	public Response removeShift(Connection c, long shiftId);
	public Response getAllShifts(Connection c);
}