using System;
namespace DBServer.Models {
    public class Company {
        public Company () { }
        public Company (long arg1, string arg2, string arg3, int arg4, string arg5) {
            this.CompanyId = arg1;
            this.CompanyName = arg2;
            this.CompanyAdress = arg3;
            this.CompanyPhone = arg4;
            this.CompanyEmail = arg5;
        }
        public long CompanyId { get; set; }
        public string CompanyName { get; set; }
        public string CompanyAdress { get; set; }
        public int CompanyPhone { get; set; }
        public string CompanyEmail { get; set; }

    }
}