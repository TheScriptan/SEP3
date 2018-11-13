using System;
namespace VikarDb.Models
{
    public class Shift
    {

        public Shift(long shiftid, long companyid, DateTime shiftdate, int shifttime, string shiftrequirements)
        {
            this.ShiftId = shiftid;
            this.CompanyId = companyid;
            this.ShiftDate = shiftdate;
            this.ShiftTime = shifttime;
            this.ShiftRequirements = shiftrequirements;
        }
        public long ShiftId { get; set; }
        public long CompanyId { get; set; }
        public DateTime ShiftDate { get; set; }
        public int ShiftTime { get; set; }
        public string ShiftRequirements { get; set; }
    }
}