select email
from employee
inner join attendance on employee.username=attendance.empusername where (attendance.date <= 2018-09-31 or  attendance.date >= 2018-09-31)