using System;
namespace DBConnectionTest.Models
{
    public class CompleteShift
    {
       public CompleteShift(){}
       public CompleteShift(long cs1, long cs2, long cs3, long cs4, Boolean cs5)
      {
         this.ShiftDoneId = cs1;
         this.ShiftId = cs2;
         this.CompanyId = cs3;
         this.StudentId = cs4;
         this.Status = cs5;
      }
      
        
        public long ShiftDoneId { get; set; }
        public long ShiftId { get; set; }
        public long CompanyId { get; set; }
        public long StudentId { get; set; }
        public Boolean Status { get; set; }
      

    }
}