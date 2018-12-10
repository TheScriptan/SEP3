package com.bl.model;

public class CompleteShift {
	private int ShiftDoneID;
	private int shiftID;
	private int companyID;
	private int studentID;
	private boolean status;
	
	public CompleteShift(int shiftDoneID, int shiftID, int companyID, int studentID, boolean status) {
		ShiftDoneID = shiftDoneID;
		this.shiftID = shiftID;
		this.companyID = companyID;
		this.studentID = studentID;
		this.status = status;
	}
	
	public int getShiftDoneID() {
		return ShiftDoneID;
	}
	public void setShiftDoneID(int shiftDoneID) {
		ShiftDoneID = shiftDoneID;
	}
	public int getShiftID() {
		return shiftID;
	}
	public void setShiftID(int shiftID) {
		this.shiftID = shiftID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "CompleteShift [ShiftDoneID=" + ShiftDoneID + ", shiftID=" + shiftID + ", companyID=" + companyID
				+ ", studentID=" + studentID + ", status=" + status + "]";
	}
}
