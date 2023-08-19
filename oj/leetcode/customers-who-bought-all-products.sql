/* Write your PL/SQL query statement below */
SELECT A.customer_id
FROM
(
    SELECT
        C.customer_id
        ,COUNT(DISTINCT C.product_key) countCustomer
    FROM
        Customer C
    GROUP BY
        C.customer_id
) A,
(
    SELECT COUNT(*) countProduct FROM Product
) B
WHERE A.countCustomer = B.countProduct;