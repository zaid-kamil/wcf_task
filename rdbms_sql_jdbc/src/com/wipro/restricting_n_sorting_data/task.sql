-- 3
SELECT 
    last_name AS LAST_NAME, 
    salary AS SALARY
FROM 
    employees
WHERE 
    salary < 5000 OR salary > 12000;

-- 4
  SELECT 
    last_name AS LAST_NAME, 
    job_id AS JOB_ID, 
    hire_date AS HIRE_DATE
FROM 
    employees
WHERE 
    last_name IN ('Matos', 'Taylor')
ORDER BY 
    hire_date ASC;

-- 7

SELECT 
    last_name AS LAST_NAME, 
    hire_date AS HIRE_DATE
FROM 
    employees
WHERE 
    hire_date BETWEEN '1994-01-01' AND '1994-12-31';

-- 8

SELECT 
    last_name AS LAST_NAME, 
    job_title AS JOB_TITLE
FROM 
    employees
WHERE 
    manager_id IS NULL;

-- 13
SELECT 
    last_name AS LAST_NAME
FROM 
    employees
WHERE 
    last_name LIKE '%a%' AND last_name LIKE '%e%';