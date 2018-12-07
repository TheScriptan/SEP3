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
