# SEP3 WebAPI Requests

---
PUT - create
POST - modify


|Auth: Admin   |GET|POST|PUT|DELETE|
|--------------|:-:|:--:|:-:|:----:|
|employee      | x | x  | x |  x   |
|student       | x | x  | x |  x   |
|company       | x | x  | x |  x   |
|shift         | x | x  | x |  x   |
|completeShift | x | x  |   |      |

|Auth: Student |GET|POST|PUT|DELETE|
|--------------|:-:|:--:|:-:|:----:|
|employee      |   |    |   |      |
|student       |   |    |   |      |
|company       |   |    |   |      |
|shift         | x |    |   |      |
|completeShift | x |    |   |      |

**SHIFT**

POST
   - ShiftId : 0 => id autoincrements
     - after delete of ID, you can specify id, for example if shift with ID = 2 was deleted from
      from database u can select ShiftID : 2 (not recommended to keep system stable)
   - DateTime format => YYYY-MM-DDTHH:MM:SS 
{
	"ShiftId":"0", 
	"CompanyId":"1",
	"ShiftDate":"2005-02-21T02:01:00",
	"ShiftTime":"5",
	"ShiftRequirements":"jacfcsket"
}