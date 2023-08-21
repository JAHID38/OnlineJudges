# Write your MySQL query statement below
select * from users
where mail REGEXP '^[a-zA-Z][[:alnum:]_.-]*@leetcode\\.com$';