using System;
namespace VikarDb.Models
{
    public class CompleteShift
    {

        public CompleteShift(long shiftdoneid, long shiftid, long companyid, long studentid, string status)
        {
            this.ShiftDoneId = shiftdoneid;
            this.ShiftId = shiftid;
            this.CompanyId = companyid;
            this.StudentId = studentid;
            this.Status = status;
            
        }
        public long ShiftDoneId { get; set; }
        public long ShiftId { get; set; }
        public long CompanyId { get; set; }
        public long StudentId { get; set; }
        public string Status { get; set; }
       
    }
}