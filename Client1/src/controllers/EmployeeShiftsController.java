package controllers;

import java.util.List;

import models.Shift;
import serverConnection.Connection;
import utils.Utils;
import serverConnection.ShiftHandler;

public class EmployeeShiftsController {

	private ShiftHandler sh;
	
   public EmployeeShiftsController() {
	   sh = new ShiftHandler();
   }

   public boolean addShift(Connection c, Shift shift) {
	   return sh.addShift(c, shift).getResponseCode().equals(Utils.Responses.OBJECT_ADDED.toString());
   }
   
   public boolean deleteShift(Connection c, Long shiftId) {
	   return sh.removeShift(c, shiftId).getResponseCode().equals(Utils.Responses.OBJECT_DELETED.toString());
   }
   
   
   public List<Shift> getAllShifts(Connection c) {

	   return Utils.deserializeList(sh.getAllShifts(c).getArguments()[0], Shift[].class);
   }
}