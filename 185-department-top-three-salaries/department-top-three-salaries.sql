select department, employee, salary from (
    select department.name as department,
    employee.name as employee,
    employee.salary as salary,
    dense_rank() over (partition by departmentid
                        order by salary desc) as rnk
    from employee
    join department
        on employee.departmentid = department.id
) as x
where rnk < 4