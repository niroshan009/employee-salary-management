## Setup locally
Please update the below properties inside the application.properties
```
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url= #DB host:port and database EX:- jdbc:mysql://localhost:3306/employee_salary
spring.datasource.username= #db username
spring.datasource.password= #db password
```

### to run UI project parallelly in the same host
Add ```@CrossOrigin(origins = "http://localhost:4200")``` annotation to the class level of ```EmployeeController``` class.

### Endpoints
Following endpoints are exposed 

| Endpoint            | HTTP Method | Description                    |
|---------------------|-------------|--------------------------------|
| ```/users/upload``` | POST        | Save employees to the database |
| ```/users  ```      | GET         | Search saved employees         |

For search following parameters should be provided
 * minSalary
 * maxSalary
 * offset
 * limit
 * sort

Below is the sample search URL.
```/users?minSalary=1&maxSalary=800&offset=0&limit=10&sort=-name```