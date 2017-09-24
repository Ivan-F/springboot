# springboot
## init
提交空目录
find . -type d -empty -exec touch {}/.gitkeep \;
--

http://blog.didispace.com/books/spring-boot-reference/IV.%20Spring%20Boot%20features/27.1.1.%20Spring%20MVC%20auto-configuration.html

Oracle 查询树 start with sec1 connect by prior sec2 where sec3


所有反馈：
-- 
SELECT 
    FEED.*
    FROM T_MEMBER_FEEDBACK FEED
    where parent_id = '-1'
    
-- 
携带回复标识的反馈：
-- 
SELECT 
    FEED.*,
    (select count(*) from T_MEMBER_FEEDBACK where PARENT_ID = FEED.FEEDBACK_ID) PARENT_ID_
    FROM T_MEMBER_FEEDBACK FEED
    where parent_id = '-1'
 -- 
 查反馈 + 反馈对应的回复
 -- 
SELECT * FROM
    t_member_feedback t
    start with t.feedback_id ="123123"
    connect by prior t.feedback_id = t.PARENT_ID

 -- 
反馈 + 对应回复 -> 筛调回复
 -- 
SELECT * FROM
    t_member_feedback t
    where parent_id= '-1'
    start with t.feedback_id in(select feedback_id from t_member_feedback where parent_id = '-1')
    connect by prior t.feedback_id = t.PARENT_ID
    