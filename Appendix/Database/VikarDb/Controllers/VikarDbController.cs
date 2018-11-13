using Microsoft.AspNetCore.Mvc; 
using System.Collections.Generic; 
using System.Linq; 
using VikarDb.Models;
using VikarDb; 


namespace TodoApi.Controllers {     
[Route("api/[controller]")]     
[ApiController]     
public class VikarDbController : ControllerBase     
{        
private readonly DatabaseContext _context;          
public VikarDbController(DatabaseContext context)         
{             _context = context;              
if (_context.Shift.Count() == 0)             
{                 
 _context.Shift.Add(new Shift (555555,1,new System.DateTime(),14,"shoes" ));             
_context.SaveChanges();}}             
[HttpGet] 
public ActionResult<List<Shift>> GetAll() 
{     
return _context.Shift.ToList(); 
} 
 
[HttpGet("{id}", Name = "555555")] 
public ActionResult<Shift> GetById(long companyid) 
{    
var item = _context.Shift.Find(companyid);     
if (item == null)    
{         
return NotFound();     
}     
return item; 
}
}         
}            


