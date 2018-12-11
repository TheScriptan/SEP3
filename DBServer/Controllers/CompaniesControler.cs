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
    public class CompaniesController : ControllerBase
    {
       private readonly CompanyContext _context;

      public CompaniesController (CompanyContext context) => _context = context;
         
        // GET api/values
        [HttpGet]
        public ActionResult<List<Company>> Get()
        {
            return _context.Companies.ToList();
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<Company> Get(long id)
        {
            return _context.Companies.Single(c => c.CompanyId == id);
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] Company company)
        {
            _context.Companies.Add(company);
            _context.SaveChanges ();
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(long id, [FromBody] string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(long id)
        {
            var delCompany = _context.Companies.Single(c => c.CompanyId == id);
            _context.Companies.Remove(delCompany);
            _context.SaveChanges();
        }
    }
}
