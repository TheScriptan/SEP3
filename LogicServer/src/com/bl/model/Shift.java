package com.bl.model;

import java.util.Date;

public class Shift {
	private long shiftId;
	private long companyId;
	private Date shiftDate;
	private int shiftTime;
	private String shiftRequirements;
	public Shift(long shiftId, long companyId, Date shiftDate, int shiftTime, String shiftRequirements) {
		this.shiftId = shiftId;
		this.companyId = companyId;
		this.shiftDate = shiftDate;
		this.shiftTime = shiftTime;
		this.shiftRequirements = shiftRequirements;
	}
	public long getshiftId() {
		return shiftId;
	}
	public void setshiftId(long shiftId) {
		this.shiftId = shiftId;
	}
	public long getcompanyId() {
		return companyId;
	}
	public void setcompanyId(long companyId) {
		this.companyId = companyId;
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
		return "Shift [shiftId=" + shiftId + ", companyId=" + companyId + ", shiftDate=" + shiftDate + ", shiftTime="
				+ shiftTime + ", shiftRequirements=" + shiftRequirements + "]";
	}
}
