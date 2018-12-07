using System;
using System.ComponentModel.DataAnnotations;

namespace DBServer.Models
{
    public class CompleteShift
    {
       public CompleteShift(){}
       public CompleteShift(long cs1, long cs2, long cs3, long cs4, DateTime cs5,DateTime cs6)
      {
         this.ShiftDoneId = cs1;
         this.ShiftId = cs2;
         this.CompanyId = cs3;
         this.StudentId = cs4;
         this.checkIn = cs5;
         this.checkIn = cs6;
         
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