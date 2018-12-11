using System;
namespace DBServer.Models {
    public class Student {
        public Student () { }
        public Student (string s1, string s2, string s3, string s4, string s5, string s6, string s7, double s8) {
            this.StudentID = s1;
            this.Password = s2;
            this.StudentName = s3;
            this.StudentAdress = s4;
            this.StudentPhoneNo = s5;
            this.StudentEmail = s6;
            this.StudentBankAcc = s7;
            this.StudentMonthWorkedHours = s8;

        }
        public string StudentID { get; set; }
        public string Password { get; set; }
        public string StudentName { get; set; }
        public string StudentAdress { get; set; }
        public string StudentPhoneNo { get; set; }
        public string StudentEmail { get; set; }
        public string StudentBankAcc { get; set; }
        public double StudentMonthWorkedHours { get; set; }

    }
}
