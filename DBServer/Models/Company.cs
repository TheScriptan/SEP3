using System;
namespace DBServer.Models {
    public class Company {
        public Company () { }
        public Company (long arg1, string arg2, string arg3, string arg4, string arg5) {
            this.CompanyID = arg1;
            this.CompanyName = arg2;
            this.CompanyAdress = arg3;
            this.CompanyPhone = arg4;
            this.CompanyEmail = arg5;
        }
        public long CompanyID { get; set; }
        public string CompanyName { get; set; }
        public string CompanyAdress { get; set; }
        public string CompanyPhone { get; set; }
        public string CompanyEmail { get; set; }

    }
}
