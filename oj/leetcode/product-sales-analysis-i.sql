# Write your MySQL query statement below
SELECT
    prod.product_name,
    sale.year,
    sale.price
FROM
    Sales sale
INNER JOIN
    Product prod
ON
    sale.product_id = prod.product_id;