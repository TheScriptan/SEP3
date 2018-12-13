package com.bl.model;

public class Employee {
	private String employeeId;
	private String password;
	private String employeeName;
	private String employeeAdress;
	private String employeePhoneNo;
	private String employeeEmail;
	private String employeeBankAcc;
	private double employeeMonthWorkedHours;
	
	public Employee(String employeeId, String password, String employeeName, String employeeAdress, String employeePhoneNo, String employeeEmail,
			String employeeBankAcc, double employeeMonthWorkedHours) {
		this.employeeId = employeeId;
		this.password = password;
		this.employeeName = employeeName;
		this.employeeAdress = employeeAdress;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeEmail = employeeEmail;
		this.employeeBankAcc = employeeBankAcc;
		this.employeeMonthWorkedHours = employeeMonthWorkedHours;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public boolean verifyEmployeeId(String employeeId)
	{
    	employeeId = employeeId.trim();

    	if(employeeId == null || employeeId.equals(""))
        return false;
    	if(!employeeId.matches("^[0-9]*"))
        return false;

   	 return true;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean verifyPassword(String password)
	{
    	password = password.trim();

    	if(password == null || password.equals(""))
        return false;
    	if(!password.matches("^[0-9]*"))
        return false;

   	 return true;
	}
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean verifyEmployeeName(String employeeName)
	{
    	employeeName = employeeName.trim();

    	if(employeeName == null || employeeName.equals(""))
        return false;
    	if(!employeeName.matches("^[a-zA-Z]*"))
        return false;

   	 return true;
	}
	public String getEmployeeAdress() {
		return employeeAdress;
	}

	public void setEmployeeAdress(String employeeAdress) {
		this.employeeAdress = employeeAdress;
	}
	public boolean verifyEmployeeAdress(String employeeAdress)
	{
    	employeeAdress = employeeAdress.trim();

    	if(employeeAdress == null || employeeAdress.equals(""))
        return false;
    	if(!employeeAdress.matches("^[a-zA-Z0-9]*"))
        return false;

   	 return true;
	}
	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}

	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}
	public boolean verifyEmployeePhoneNo(String employeePhoneNo)
	{
    	employeePhoneNo = employeePhoneNo.trim();

    	if(employeePhoneNo == null || employeePhoneNo.equals(""))
        return false;
    	if(!employeePhoneNo.matches("^[0-9]*"))
        return false;

   	 return true;
	}
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public boolean verifyEmployeeEmail(String employeeEmail)
	{
   	 employeeEmail = employeeEmail.trim();
	
    	if(employeeEmail == null || employeeEmail.equals(""))
        return false;

    	if(!employeeEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
        return false;

    	return true;
	}
	public String getEmployeeBankAcc() {
		return employeeBankAcc;
	}

	public void setEmployeeBankAcc(String employeeBankAcc) {
		this.employeeBankAcc = employeeBankAcc;
	}
	public boolean verifyEmployeeBankAcc(String employeeBankAcc)
	{
    	employeeBankAcc = employeeBankAcc.trim();

    	if(employeeBankAcc == null || employeeBankAcc.equals(""))
        return false;
    	if(!employeeBankAcc.matches("^[0-9]*"))
        return false;

   	 return true;
	}
	
	public double getEmployeeMonthWorkedHours() {
		return employeeMonthWorkedHours;
	}

	public void setEmployeeMonthWorkedHours(int employeeMonthWorkedHours) {
		this.employeeMonthWorkedHours = employeeMonthWorkedHours;
	}
	public boolean verifyEmployee()
	{
		if(!verifyEmployeeId(employeeId) && verifyPassword(password) && verifyEmployeeName(employeeName) && verifyEmployeeAdress(employeeAdress) && verifyEmployeePhoneNo(employeePhoneNo) && verifyEmployeeEmail(employeeEmail) && verifyEmployeeBankAcc(employeeBankAcc))
			return false;
		return true;
		
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", password=" + password + ", employeeName=" + employeeName + ", employeeAdress="
				+ employeeAdress + ", employeePhoneNo=" + employeePhoneNo + ", employeeEmail=" + employeeEmail + ", employeeBankAcc=" + employeeBankAcc + ", employeeMonthWorkedHours="
				+ employeeMonthWorkedHours;
	}
}
