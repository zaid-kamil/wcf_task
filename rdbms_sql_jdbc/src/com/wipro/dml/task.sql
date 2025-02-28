-- 3
INSERT INTO employees
VALUES (201, 'Michael', 'Hartstein', 20, 13000);

-- To check whether the data is inserted
SELECT 
    employee_id, 
    first_name, 
    last_name, 
    department_id, 
    salary
FROM 
    employees
WHERE 
    employee_id = 201;


-- 5

-- Insert a record without specifying the salary column
INSERT INTO employees (employee_id, first_name, last_name, department_id)
VALUES (202, 'Pat', 'Fay', 20);

-- Insert another record without specifying the salary column
INSERT INTO employees (employee_id, first_name, last_name, department_id)
VALUES (203, 'Susan', 'Mavris', 40);

-- To check whether the data is inserted
SELECT 
    employee_id, 
    first_name, 
    last_name, 
    department_id, 
    salary
FROM 
    employees
WHERE 
    employee_id IN (202, 203);

-- 7

-- Increase salary by 10% for all employees in department 90
UPDATE employees
SET salary = salary * 1.10
WHERE department_id = 90;

-- To check whether the data is updated
SELECT 
    employee_id, 
    first_name, 
    last_name, 
    department_id, 
    salary
FROM 
    employees
WHERE 
    department_id = 90;

-- 9
-- Delete employees whose first name or last name contains 'man'
DELETE FROM employees
WHERE 
    first_name LIKE '%man%' OR 
    last_name LIKE '%man%';

-- To check whether the data is deleted
SELECT 
    employee_id, 
    first_name, 
    last_name, 
    department_id, 
    salary
FROM 
    employees
WHERE 
    first_name LIKE '%man%' OR 
    last_name LIKE '%man%';