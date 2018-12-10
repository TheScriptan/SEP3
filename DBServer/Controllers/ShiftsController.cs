using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using DBServer.Models;

namespace DBServer.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ShiftsController : ControllerBase
    {
       private readonly CompanyContext _context;

      public ShiftsController (CompanyContext context) => _context = context;
         
        // GET api/values
        [HttpGet]
        public ActionResult<List<Shift>> Get()
        {
            return _context.Shifts.ToList();
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] Shift shift)
        {
            _context.Shifts.Add(shift);
            _context.SaveChanges();
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
            var shift =_context.Shifts.Single();
            //TODO
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            var deleteShift = _context.Shifts.Single(s => s.ShiftId == id);
            _context.Shifts.Remove(deleteShift);
            _context.SaveChanges();
            
        }
    }
}
