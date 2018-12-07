using System;
namespace DBConnectionTest.Models {
    public class Employee {
        public Employee () { }
        public Employee (long e1, string e2, string e3, string e4, int e5, string e6, int e7, int e8) {
            this.EmployeeId = e1;
            this.Password = e2;
            this.EmployeeName = e3;
            this.EmployeeAdress = e4;
            this.EmployeePhoneNo = e5;
            this.EmployeeEmail = e6;
            this.EmployeeBankAcc = e7;
            this.EmployeeMonthWorkedHours = e8;

        }
        public long EmployeeId { get; set; }
        public string Password { get; set; }
        public string EmployeeName { get; set; }
        public string EmployeeAdress { get; set; }
        public int EmployeePhoneNo { get; set; }
        public string EmployeeEmail { get; set; }
        public int EmployeeBankAcc { get; set; }
        public int EmployeeMonthWorkedHours { get; set; }

    }
}