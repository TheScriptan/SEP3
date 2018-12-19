using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DBServer.Models;
using Microsoft.AspNetCore.Mvc;

namespace DBServer.Controllers {
    [Route ("api/[controller]")]
    [ApiController]
    public class ShiftsDoneController : ControllerBase {
        private readonly CompanyContext _context;

        public ShiftsDoneController (CompanyContext context) => _context = context;

        // GET api/shiftsdone
        [HttpGet]
        public ActionResult<List<CompleteShift>> Get () {
            return _context.CompleteShifts.ToList ();
        }

        // GET api/values/5
        [HttpGet ("{id}")]
        public ActionResult<CompleteShift> Get (long id) {
            return _context.CompleteShifts.Single (cs => cs.ShiftDoneId == id);
        }

        // POST api/values
        [HttpPost]
        public void Post ([FromBody] CompleteShift cs) {

            _context.CompleteShifts.Add (cs);
            _context.SaveChanges ();
        }

        // PUT api/values/5
        [HttpPut]
        public void Put (CompleteShift cs) {
            _context.CompleteShifts.Add (cs);
            _context.SaveChanges (); }

        // DELETE api/values/5
        [HttpDelete ("{id}")]
        public void Delete (long id) {
            var cs = _context.CompleteShifts.Single (c => c.ShiftDoneId == id);
            _context.CompleteShifts.Remove (cs);
            _context.SaveChanges ();

        }
    }
}