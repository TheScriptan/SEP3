using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using DBConnectionTest.Models;
using DBConnectionTest;

namespace DBConnectionTest.Controllers {
   [Route ("api/[controller]")]
   [ApiController]
   public class DBConnectionTestController : ControllerBase {
      private readonly DBConnectionTestContext _context;

      public DBConnectionTestController (DBConnectionTestContext context) {
         _context = context;
         if (_context.Shifts.Count() == 0) {
            _context.Shifts.Add(new Shift {ShiftId = 1, CompanyId = 1, ShiftDate = new System.DateTime(), ShiftTime = 14, ShiftRequirements = "shoes" });
            _context.SaveChanges();
         }
      }

      // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id)
        {
            _context.Shifts.Add(new Shift { ShiftId = (long)id , CompanyId = 1, ShiftDate = new System.DateTime(), ShiftTime = 14, ShiftRequirements = "shoes" });
            _context.SaveChanges();}



      // GET api/DBConnectionTest/1
      [HttpGet ("{id}")]
      public  ActionResult<Shift> GetById (long id) {
         
         return _context.Shifts.Find(id);
      }
   }
}