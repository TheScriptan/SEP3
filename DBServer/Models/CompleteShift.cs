using System;
using System.ComponentModel.DataAnnotations;

namespace DBServer.Models {
    public class CompleteShift {
        public CompleteShift () { }
        public CompleteShift (long arg1, long arg2, long arg3, long arg4, DateTime arg5, DateTime arg6) {
            this.ShiftDoneId = arg1;
            this.ShiftId = arg2;
            this.CompanyId = arg3;
            this.StudentId = arg4;
            this.checkIn = arg5;
            this.checkIn = arg6;

        }

        [Key]
        public long ShiftDoneId { get; set; }
        public long ShiftId { get; set; }
        public long CompanyId { get; set; }
        public long StudentId { get; set; }
        public DateTime checkIn { get; set; }
        public DateTime checkOut { get; set; }

    }
}