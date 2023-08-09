/* Write your T-SQL query statement below */

SELECT COUNT(DISTINCT customer_id) rich_count
FROM Store
WHERE amount > 500;