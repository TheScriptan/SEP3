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
	public boolean verifyCompanyID(long companyID)
	{
   	companyID = companyID.trim();
   	if(companyID == null || companyID.equals(""))
        return false;
    	if(!companyID.matches("[0-9]*"))
        return false;
   	return true;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public boolean verifyCompanyName(String companyName)
	{
    	companyName = companyName.trim();

    	if(companyName == null || companyName.equals(""))
        return false;
    	if(!companyName.matches("[a-zA-Z0-9]*"))
        return false;

   	 return true;
	}
	
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public boolean verifyCompanyAdress(String companyAdress)
	{
    	companyAdress = companyAdress.trim();

    	if(companyAdress == null || companyAdress.equals(""))
        return false;

    	if(!companyAdress.matches("[a-zA-Z]*"))
        return false;

   	 return true;
	}
	
	
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	private boolean verifyCompanyPhone(long companyPhone)
	{
   	 companyPhone = companyPhone.trim();

   	 if(companyPhone == null || companyPhone.equals(""))
        return false;

    	if(!companyPhone.matches("[0-9]*"))
        return false;

   	 return true;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public boolean verifyCompanyEmail(String companyEmail)
	{
   	 companyEmail = companyEmail.trim();
	
    	if(companyEmail == null || companyEmail.equals(""))
        return false;

    	if(!companyEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
        return false;

    	return true;
	}
	public boolean verify()
	{
		if(!(verifyCompanyName() && verifyCompanyName() && verifyCompanyAdress() && verifyCompanyPhone() && verifyCompanyEmail()))
			return false;
		return true;
		
	}	
	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyPhone=" + companyPhone + ", companyEmail=" + companyEmail + "]";
	}
}
