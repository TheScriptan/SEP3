using System;

namespace DBServer.Models {
    public class Shift {
        public Shift () { }
        public Shift (long v1, int v2, DateTime dateTime, double v3, string v4) {
            this.ShiftID = v1;
            this.CompanyID = v2;
            this.ShiftDate = dateTime;
            this.ShiftTime = v3;
            this.ShiftRequirements = v4;
        }
        public long ShiftID { get; set; }
        public int CompanyID { get; set; }
        public DateTime ShiftDate { get; set; }
        public double ShiftTime { get; set; }
        public string ShiftRequirements { get; set; }



    }
}
