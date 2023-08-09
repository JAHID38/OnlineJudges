# Write your MySQL query statement below
WITH numbers AS
(
SELECT
    num, COUNT(num) num_count
FROM
    MyNumbers
GROUP BY
    num
)

SELECT MAX(num) num
FROM numbers
WHERE num_count = 1;