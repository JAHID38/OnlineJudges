# Write your MySQL query statement below
WITH cteSalaryCategory AS
(
SELECT
    'Low Salary' category
UNION
SELECT
    'Average Salary' cat
UNION
SELECT
    'High Salary' cat
)

SELECT c.category, IFNULL(A.accounts_count, 0) accounts_count
FROM(
SELECT
    CASE
        WHEN income < 20000 THEN 'Low Salary'
        WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
        WHEN income > 50000 THEN 'High Salary'
    END category, COUNT(income) accounts_count
FROM
    Accounts
GROUP BY
    category
) A
RIGHT JOIN cteSalaryCategory c
ON c.category = A.category;