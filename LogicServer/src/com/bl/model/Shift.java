package com.bl.model;

import java.util.Date;

public class Shift {
	private long shiftID;
	private long companyID;
	private Date shiftDate;
	private int shiftTime;
	private String shiftRequirements;
	public Shift(long shiftID, long companyID, Date shiftDate, int shiftTime, String shiftRequirements) {
		this.shiftID = shiftID;
		this.companyID = companyID;
		this.shiftDate = shiftDate;
		this.shiftTime = shiftTime;
		this.shiftRequirements = shiftRequirements;
	}
	public long getShiftID() {
		return shiftID;
	}
	public void setShiftID(long shiftID) {
		this.shiftID = shiftID;
	}
	public long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	public Date getShiftDate() {
		return shiftDate;
	}
	public void setShiftDate(Date shiftDate) {
		this.shiftDate = shiftDate;
	}
	public int getShiftTime() {
		return shiftTime;
	}
	public void setShiftTime(int shiftTime) {
		this.shiftTime = shiftTime;
	}
	public String getShiftRequirements() {
		return shiftRequirements;
	}
	public void setShiftRequirements(String shiftRequirements) {
		this.shiftRequirements = shiftRequirements;
	}
	
	@Override
	public String toString() {
		return "Shift [shiftID=" + shiftID + ", companyID=" + companyID + ", shiftDate=" + shiftDate + ", shiftTime="
				+ shiftTime + ", shiftRequirements=" + shiftRequirements + "]";
	}
}
