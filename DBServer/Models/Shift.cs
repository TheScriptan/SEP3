using System;

namespace DBServer.Models {
    public class Shift {
        public Shift () { }
        public Shift (long v1, long v2, DateTime dateTime, double v3, string v4) {
            this.ShiftId = v1;
            this.CompanyId = v2;
            this.ShiftDate = dateTime;
            this.ShiftTime = v3;
            this.ShiftRequirements = v4;
        }
            
            public Shift (long v1, long v2, DateTime dateTime, double v3, string v4, bool released) {
            this.ShiftId = v1;
            this.CompanyId = v2;
            this.ShiftDate = dateTime;
            this.ShiftTime = v3;
            this.ShiftRequirements = v4;
            this.Released = released;
        }
        public long ShiftId { get; set; }
        public long CompanyId { get; set; }
        public DateTime ShiftDate { get; set; }
        public double ShiftTime { get; set; }
        public string ShiftRequirements { get; set; }

        public bool Released { get; set; }



    }
}
