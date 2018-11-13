using Microsoft.EntityFrameworkCore;

namespace DBConnectionTest.Models
{
   public class DBConnectionTestContext : DbContext
   {
      public DBConnectionTestContext(DbContextOptions<DBConnectionTestContext> options) : base(options){}

      public DbSet<Company> Companies { get; set; }
      public DbSet<Shift> Shifts { get; set; }

      
   }
}