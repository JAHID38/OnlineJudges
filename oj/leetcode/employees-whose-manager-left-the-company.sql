/* Write your PL/SQL query statement below */

SELECT E.employee_id employee_id
FROM Employees E
WHERE E.salary < 30000 AND
     NOT EXISTS (
        SELECT M.manager_id FROM Employees M
        WHERE E.manager_id = M.employee_id
    )
    AND E.manager_id > 0
ORDER BY E.employee_id;