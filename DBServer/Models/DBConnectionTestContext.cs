using Microsoft.EntityFrameworkCore;

namespace DBConnectionTest.Models {
    public class DBConnectionTestContext : DbContext {
        public DBConnectionTestContext (DbContextOptions<DBConnectionTestContext> options) : base (options) { }

        public DbSet<Company> Companies { get; set; }
        public DbSet<Shift> Shifts { get; set; }
        public DbSet<CompleteShift> CompleteShifts { get; set; }
        public DbSet<Employee> Employees { get; set; }
        public DbSet<Student> Students { get; set; }

    }
}