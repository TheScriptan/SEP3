package com.bl.model;

public class Company {
	private long companyID;
	private String companyName;
	private String companyAddress;
	private String companyPhone;
	private String companyEmail;
	public Company(long companyID, String companyName, String companyAddress, String companyPhone,
			String companyEmail) {
		this.companyID = companyID;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyPhone = companyPhone;
		this.companyEmail = companyEmail;
	}
	
	public long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyPhone=" + companyPhone + ", companyEmail=" + companyEmail + "]";
	}
}
