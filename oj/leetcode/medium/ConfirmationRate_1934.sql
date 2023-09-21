/* Write your T-SQL query statement below */
SELECT
    A.user_id,
    CASE
        WHEN ISNULL(A.totalUser, 0) = 0 THEN 0
        ELSE
            ROUND(CAST(ISNULL(B.confirmedUser, 0) AS DECIMAL(3,2))/A.totalUser, 2)
    END confirmation_rate
FROM
(
    SELECT
        s.user_id,
        COUNT(c.user_id) totalUser
    FROM
        Signups s
    LEFT JOIN
        Confirmations c
    ON s.user_id = c.user_id
    GROUP BY s.user_id
) A
LEFT JOIN
(
    SELECT
        c.user_id,
        COUNT(c.user_id) confirmedUser
    FROM
        Confirmations c
    WHERE
        action = 'confirmed'
    GROUP BY
        c.user_id
) B
ON A.user_id = B.user_id