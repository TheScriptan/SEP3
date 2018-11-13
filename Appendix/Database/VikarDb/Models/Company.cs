using System;
namespace VikarDb.Models
{
    public class Company
    {

        public Company(long companyid, string companyname, string companyadress, string employeeadress, int companyphone, string companyemail)
        {
            this.CompanyId = companyid;
            this.CompanyName = companyname;
            this.CompanyAdress = companyadress;
            this.CompanyPhone = companyphone;
            this.CompanyEmail = companyemail;
            
        }
        public long CompanyId { get; set; }
        public string CompanyName { get; set; }
        public string CompanyAdress { get; set; }
        public int CompanyPhone { get; set; }
        public string CompanyEmail { get; set; }
       
    }
}