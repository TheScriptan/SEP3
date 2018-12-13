package com.bl.model;

public class Student {
	private String studentId;
	private String password;
	private String studentName;
	private String studentAdress;
	private String studentPhoneNo;
	private String studentEmail;
	private String studentBankAcc;
	private double studentMonthWorkedHours;
	
	public Student(String studentId, String password, String studentName, String studentAdress, String studentPhoneNo, String studentEmail, String studentBankAcc, double studentMonthWorkedHours) {
		this.studentId = studentId;
		this.password = password;
		this.studentName = studentName;
		this.studentAdress = studentAdress;
		this.studentPhoneNo = studentPhoneNo;
		this.studentEmail = studentEmail;
		this.studentBankAcc = studentBankAcc;
		this.studentMonthWorkedHours = studentMonthWorkedHours;
		
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public boolean verifyStudentId(String studentId)
	{
    	studentId = studentId.trim();

    	if(studentId == null || studentId.equals(""))
        return false;
    	if(!studentId.matches("^[0-9]*"))
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
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public boolean verifyStudentName(String studentName)
	{
    	studentName = studentName.trim();

    	if(studentName == null || studentName.equals(""))
        return false;
    	if(!studentName.matches("^[a-zA-Z]*"))
        return false;

   	 return true;
	}
	
	public String getStudentAdress() {
		return studentAdress;
	}

	public void setAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}
	public boolean verifyStudentAdress(String studentAdress)
	{
    	studentAdress = studentAdress.trim();

    	if(studentAdress == null || studentAdress.equals(""))
        return false;
    	if(!studentAdress.matches("^[a-zA-Z0-9]*"))
        return false;

   	 return true;
	}
	
	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}

	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}
	public boolean verifyStudentPhoneNo(String studentPhoneNo)
	{
    	studentPhoneNo = studentPhoneNo.trim();

    	if(studentPhoneNo == null || studentPhoneNo.equals(""))
        return false;
    	if(!studentPhoneNo.matches("^[0-9]*"))
        return false;

   	 return true;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public boolean verifyStudentEmail(String studentEmail)
	{
   	 studentEmail = studentEmail.trim();
	
    	if(studentEmail == null || studentEmail.equals(""))
        return false;

    	if(!studentEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
        return false;

    	return true;
	}
	
	public String getStudentBankAcc() {
		return studentBankAcc;
	}

	public void setStudentBankAcc(String studentBankAcc) {
		this.studentBankAcc = studentBankAcc;
	}
	public boolean verifyStudentBankAcc(String studentBankAcc)
	{
    	studentBankAcc = studentBankAcc.trim();

    	if(studentBankAcc == null || studentBankAcc.equals(""))
        return false;
    	if(!studentBankAcc.matches("^[0-9]*"))
        return false;

   	 return true;
	}
	
	public double getStudentMonthWorkedHours() {
		return studentMonthWorkedHours;
	}

	public void setStudentMonthWorkedHours(double studentMonthWorkedHours) {
		this.studentMonthWorkedHours = studentMonthWorkedHours;
	}
	public boolean verifyStudent()
	{
		if(!verifyStudentId(studentId) && verifyPassword(password) && verifyStudentName(studentName) && verifyStudentAdress(studentAdress) && verifyStudentPhoneNo(studentPhoneNo) && verifyStudentEmail(studentEmail) && verifyStudentBankAcc(studentBankAcc))
			return false;
		return true;
	}
	// add info 
	@Override
	public String toString() {
		return this.studentId + " " + this.studentName;
	}
// 	public String toString() {
// 		return "Employee [employeeId=" + employeeId + ", password=" + password + ", employeeName=" + employeeName + ", employeeAdress="
// 				+ employeeAdress + ", employeePhoneNo=" + employeePhoneNo + ", employeeEmail=" + employeeEmail + ", employeeBankAcc=" + employeeBankAcc + ", employeeMonthWorkedHours="
// 				+ employeeMonthWorkedHours;
// 	}
}
