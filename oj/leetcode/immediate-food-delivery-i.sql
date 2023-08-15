# Write your MySQL query statement below

WITH immediateOrder_cte AS
(
    SELECT
        COUNT(delivery_id) countImmediate
    FROM
        Delivery
    WHERE
        order_date = customer_pref_delivery_date
)
SELECT
    ROUND(c.countImmediate/COUNT(*)*100, 2) immediate_percentage
FROM
    Delivery,  immediateOrder_cte c;