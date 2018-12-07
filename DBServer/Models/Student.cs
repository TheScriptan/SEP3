using System;
namespace DBServer.Models {
    public class Student {
        public Student () { }
        public Student (long s1, string s2, string s3, string s4, int s5, string s6, int s7, int s8) {
            this.StudentId = s1;
            this.Password = s2;
            this.StudentName = s3;
            this.StudentAdress = s4;
            this.StudentPhoneNo = s5;
            this.StudentEmail = s6;
            this.StudentBankAcc = s7;
            this.StudentMonthWorkedHours = s8;

        }
        public long StudentId { get; set; }
        public string Password { get; set; }
        public string StudentName { get; set; }
        public string StudentAdress { get; set; }
        public int StudentPhoneNo { get; set; }
        public string StudentEmail { get; set; }
        public int StudentBankAcc { get; set; }
        public int StudentMonthWorkedHours { get; set; }

    }
}