using System;
namespace DBServer.Models {
    public class Employee {
        public Employee () { }
        public Employee (string e1, string e2, string e3, string e4, string e5, string e6, string e7, double e8) {
            this.EmployeeID = e1;
            this.Password = e2;
            this.EmployeeName = e3;
            this.EmployeeAdress = e4;
            this.EmployeePhoneNo = e5;
            this.EmployeeEmail = e6;
            this.EmployeeBankAcc = e7;
            this.EmployeeMonthWorkedHours = e8;

        }
        public string EmployeeID { get; set; }
        public string Password { get; set; }
        public string EmployeeName { get; set; }
        public string EmployeeAdress { get; set; }
        public string EmployeePhoneNo { get; set; }
        public string EmployeeEmail { get; set; }
        public string EmployeeBankAcc { get; set; }
        public double EmployeeMonthWorkedHours { get; set; }

    }
}
