WITH countCte AS
(
  SELECT COUNT(e.managerId) countReporting, managerId
  FROM Employee e
  GROUP BY e.managerId
)

SELECT
	emp.name
FROM
	Employee emp
INNER JOIN
	countCte cc
ON
	emp.id = cc.managerId AND
	cc.countReporting > 4