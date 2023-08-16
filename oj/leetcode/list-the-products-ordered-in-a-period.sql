WITH requiredOrders_cte AS
(
    SELECT
        product_id,
        SUM(unit) sumUnit
    FROM
        Orders
    WHERE
        CONVERT(VARCHAR(7), order_date, 126) = '2020-02'
    GROUP BY
        product_id

)
SELECT
    P.product_name product_name,
    C.sumUnit unit
FROM
    Products P
INNER JOIN
    requiredOrders_cte C
ON
    P.product_id = C.product_id
    AND c.sumUnit > 99;