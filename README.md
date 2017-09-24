# springboot
## init
提交空目录
find . -type d -empty -exec touch {}/.gitkeep \;
--

http://blog.didispace.com/books/spring-boot-reference/IV.%20Spring%20Boot%20features/27.1.1.%20Spring%20MVC%20auto-configuration.html

Oracle 查询树 start with sec1 connect by prior sec2 where sec3
SELECT * FROM
    t_member_feedback t
    start with t.feedback_id in(select feedback_id from t_member_feedback where parent_id = '-1')
    connect by prior t.feedback_id = t.PARENT_ID
WHERE parent_id = '-1';
