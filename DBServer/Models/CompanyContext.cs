using Microsoft.EntityFrameworkCore;

namespace DBServer.Models {
    public class CompanyContext : DbContext {
        public CompanyContext (DbContextOptions<CompanyContext> options) : base (options) { }

        public DbSet<Company> Companies { get; set; }
        public DbSet<Shift> Shifts { get; set; }
        public DbSet<CompleteShift> CompleteShifts { get; set; }
        public DbSet<Employee> Employees { get; set; }
    
    }
}