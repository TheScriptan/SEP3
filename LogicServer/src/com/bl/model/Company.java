package com.bl.model;

public class Company {
	private long companyId;
	private String companyName;
	private String companyAdress;
	private String companyPhone;
	private String companyEmail;
	public Company(long companyId, String companyName, String companyAdress, String companyPhone,
			String companyEmail) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAdress = companyAdress;
		this.companyPhone = companyPhone;
		this.companyEmail = companyEmail;
	}
	
	
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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
    	if(!companyName.matches("^[a-zA-Z0-9]*"))
        return false;

   	 return true;
	}
	
	public String getCompanyAdress() {
		return companyAdress;
	}
	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}
	public boolean verifyCompanyAdress(String companyAdress)
	{
    	companyAdress = companyAdress.trim();

    	if(companyAdress == null || companyAdress.equals(""))
        return false;

    	if(!companyAdress.matches("^[a-zA-Z]*"))
        return false;

   	 return true;
	}
	
	
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	private boolean verifyCompanyPhone(String companyPhone)
	{
   	 companyPhone = companyPhone.trim();

   	 if(companyPhone == null || companyPhone.equals(""))
        return false;

    	if(!companyPhone.matches("^[0-9]*"))
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
	public boolean verifyCompany()
	{
		if(!verifyCompanyName(companyName) && verifyCompanyAdress(companyAdress) && verifyCompanyPhone(companyPhone) && verifyCompanyEmail(companyEmail))
			return false;
		return true;
		
	}	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAdress=" + companyAdress + ", companyPhone=" + companyPhone + ", companyEmail=" + companyEmail + "]";
				
	}
}
