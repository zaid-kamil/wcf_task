-- Populate the DEPT table with data from the DEPARTMENTS table
INSERT INTO DEPT (dept_id, dept_name)
SELECT department_id, department_name
FROM DEPARTMENTS;

-- Insert dept Id 10 and Name Accounts
INSERT INTO DEPT (dept_id, dept_name)
VALUES (10, 'Accounts');

-- Insert dept Id as null and Name as TT
INSERT INTO DEPT (dept_id, dept_name)
VALUES (NULL, 'TT');

-- Correct by giving 20 and TT
UPDATE DEPT
SET dept_id = 20
WHERE dept_name = 'TT' AND dept_id IS NULL;

-- Insert A1 as Id and Accounts
INSERT INTO DEPT (dept_id, dept_name)
VALUES ('A1', 'Accounts');

-- Correct by giving 30 and Accounts
UPDATE DEPT
SET dept_id = 30
WHERE dept_name = 'Accounts' AND dept_id = 'A1';