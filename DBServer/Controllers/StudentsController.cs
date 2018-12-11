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
    public class StudentsController : ControllerBase
    {
      private readonly StudentContext _context;

      public StudentsController (StudentContext context) => _context = context;
         
        // GET api/students
        [HttpGet]
        public ActionResult<List<Student>> Get()
        {
            return _context.Students.ToList();
        }

        // GET api/students/5
        [HttpGet("{id}")]
        public ActionResult<Student> GetById(long id)
        {
            return _context.Students.Single(s => s.StudentId.Equals(id));
        }
        
        // GET api/students/Name
        [HttpGet("{name}")]
        public ActionResult<Student> GetByName(string name)
        {
            return _context.Students.Single(s => s.StudentName.Equals(name));
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] Student student)
        {
            _context.Students.Add(student);
            _context.SaveChanges();
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(string id, [FromBody] Student student)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(string id)
        {
            var delStudent = _context.Students.Single(s => s.StudentId.Equals(id));
            _context.Students.Remove(delStudent);
            _context.SaveChanges();
        }
    }
}
