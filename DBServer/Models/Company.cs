using System;
namespace DBServer.Models {
    public class Company {
        public Company () { }
        public Company (long c1, string c2, string c3, int c4, string c5) {
            this.CompanyId = c1;
            this.CompanyName = c2;
            this.CompanyAdress = c3;
            this.CompanyPhone = c4;
            this.CompanyEmail = c5;
        }
        public long CompanyId { get; set; }
        public string CompanyName { get; set; }
        public string CompanyAdress { get; set; }
        public int CompanyPhone { get; set; }
        public string CompanyEmail { get; set; }

    }
}