import java.util.*;
import java.text.*;


public class Shift {
	private int shiftID;
	private String shiftDate;
	private String shiftTime;
	private String shiftRequirements;
	
	public Shift(int shiftId, String shiftDate, String shiftTime, String shiftRequirements) {
		this.shiftID = shiftId;
		this.shiftDate = shiftDate;
		this.shiftTime = shiftTime;
		this.shiftRequirements = shiftRequirements;
	}

	
	//Getters and Setters
	public int getShiftID() {
		return shiftID;
	}

	public void setShiftID(int shiftID) {
		this.shiftID = shiftID;
	}

	public String getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(String shiftDate) {
		this.shiftDate = shiftDate;
	}

	public String getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(String shiftTime) {
		this.shiftTime = shiftTime;
	}

	public String getShiftRequirements() {
		return shiftRequirements;
	}

	public void setShiftRequirements(String shiftRequirements) {
		this.shiftRequirements = shiftRequirements;
	}
	
	public String toString() {
		return "" + shiftID + " " + shiftDate + " " + shiftTime + " " + shiftRequirements;
	}
}
