# Write your MySQL query statement below
SELECT
    proj.project_id,
    CAST(AVG(emp.experience_years) AS DECIMAL(12,2)) average_years
FROM
    Project proj
INNER JOIN
    Employee emp
ON
    proj.employee_id = emp.employee_id
GROUP BY
    proj.project_id;