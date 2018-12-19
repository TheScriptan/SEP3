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
    public class EmployeesController : ControllerBase
    {
       private readonly CompanyContext _context;

      public EmployeesController (CompanyContext context) => _context = context;
         
        // GET api/employees
        [HttpGet]
        public ActionResult<List<Employee>> Get()
        {
            return _context.Employees.ToList();
        }

        // GET api/employees/5
        [HttpGet("{id}")]
        public ActionResult<Employee> Get(string id)
        {
            return _context.Employees.Single(e => e.EmployeeId.Equals(id));
        }

        // POST api/employees
        [HttpPost]
        public void Post([FromBody]Employee employee)
        {
            _context.Employees.Add(employee);
            _context.SaveChanges();
        }

        // PUT api/employees/5
        [HttpPut]
        public void Put([FromBody]Employee employee)
        {
        }

        // DELETE api/employees/5
        [HttpDelete("{id}")]
        public void Delete(string id)
        {
            var delEmployee = _context.Employees.Single(e => e.EmployeeId.Equals(id));
            _context.Employees.Remove(delEmployee);
            _context.SaveChanges();
        }
    }
}
