# Write your MySQL query statement below
SELECT A.product_id, A.first_year, sal.quantity quantity, sal.price price
FROM
(
  SELECT
    S.product_id, MIN(S.year) first_year
  FROM Sales S
  GROUP BY S.product_id
) A
INNER JOIN Sales sal
ON A.product_id = sal.product_id AND sal.year = A.first_year
GROUP BY A.first_year, A.product_id, quantity, price
;