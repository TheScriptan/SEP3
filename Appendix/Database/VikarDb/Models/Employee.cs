using System;
namespace VikarDb.Models
{
    public class Employee
    {

        public Employee(long employeeid, long password, string employeename, string employeeadress, int employeephoneno, string employeeemail, string employeebankacc, int employeemonthworkedhours)
        {
            this.EmployeeId = employeeid;
            this.Password = password;
            this.EmployeeName = employeename;
            this.EmployeeAdress = employeeadress;
            this.EmployeePhoneNo = employeephoneno;
            this.EmployeeEmail = employeeemail;
            this.EmployeeBankAcc = employeebankacc;
            this.EmployeeMonthWorkedHours = employeemonthworkedhours;
        }
        public long EmployeeId { get; set; }
        public long Password { get; set; }
        public string EmployeeName { get; set; }
        public string EmployeeAdress { get; set; }
        public int EmployeePhoneNo { get; set; }
        public string EmployeeEmail { get; set; }
        public string EmployeeBankAcc { get; set; }
        public int EmployeeMonthWorkedHours { get; set; }
    }
}