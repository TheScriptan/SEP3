using System;
using System.ComponentModel.DataAnnotations;

namespace DBServer.Models {
    public class CompleteShift {
        public CompleteShift () { }
        public CompleteShift (long arg1, long arg2, long arg3, string arg4, DateTime arg5, DateTime arg6) {
            this.ShiftDoneID = arg1;
            this.ShiftID = arg2;
            this.CompanyID = arg3;
            this.StudentID = arg4;
            this.checkIn = arg5;
            this.checkIn = arg6;

        }

        [Key]
        public long ShiftDoneID { get; set; }
        public long ShiftID { get; set; }
        public long CompanyID { get; set; }
        public string StudentID { get; set; }
        public DateTime checkIn { get; set; }
        public DateTime checkOut { get; set; }

    }
}
