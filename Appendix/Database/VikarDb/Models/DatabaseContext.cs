using Microsoft.EntityFrameworkCore;  
namespace VikarDb.Models {     
public class DatabaseContext : DbContext     
  {         
    public DatabaseContext(DbContextOptions<DatabaseContext> options)                            : base(options)         
{         
}          
    public DbSet<Shift> Shift { get; set; }
    public DbSet<Employee> Employee { get; set; } 
    public DbSet<Company> Company { get; set; }
    public DbSet<CompleteShift> CompleteShift { get; set; }
   } 
}