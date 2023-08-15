/* Write your PL/SQL query statement below */
SELECT
	p.product_id,
	ROUND(SUM(us.units * p.price)/SUM(us.units), 2) average_price
FROM
	Prices p
INNER JOIN
	UnitsSold us
ON
	p.product_id = us.product_id
WHERE
	us.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY
	p.product_id
