/* Write your PL/SQL query statement below */
SELECT
    S.student_id,
    S.student_name,
    Sub.subject_name,
    COUNT(E.student_id) attended_exams
FROM
    Students S
        CROSS JOIN
    Subjects Sub
        LEFT JOIN
    Examinations E ON E.student_id = S.student_id
        AND E.subject_name = Sub.subject_name
GROUP BY S.student_id , Sub.subject_name
ORDER BY S.student_id , Sub.subject_name;