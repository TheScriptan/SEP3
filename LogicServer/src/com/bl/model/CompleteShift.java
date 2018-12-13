package com.bl.model;

import java.util.Date;

public class CompleteShift {
	private long completeshiftId;
	private long shiftId;
	private long companyId;
	private String studentId;
	private Date checkIn;
	private Date checkOut;
	
	public CompleteShift(long completeshiftId, long shiftId, long companyId, String studentId, Date checkIn, Date checkOut) {
		this.completeshiftId = completeshiftId;
		this.shiftId = shiftId;
		this.companyId = companyId;
		this.studentId = studentId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long getcompleteshiftId() {
		return completeshiftId;
	}

	public void setcompleteshiftId(long completeshiftId) {
		this.completeshiftId = completeshiftId;
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

	public String getstudentId() {
		return studentId;
	}

	public void setstudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public boolean verifyStudentId(String studentId)
	{
    	studentId = studentId.trim();

    	if(studentId == null || studentId.equals(""))
        return false;
    	if(!studentId.matches("^[a-zA-Z0-9]*"))
        return false;

   	 return true;
	}
	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public boolean verifyCompleteShift()
	{
		if(!verifyStudentId(studentId) )
			return false;
		return true;
		
	}
	@Override
	public String toString() {
		return "CompleteShift [completeshiftId=" + completeshiftId + ", shiftId=" + shiftId + ", companyId=" + companyId
				+ ", studentId=" + studentId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	}
}
