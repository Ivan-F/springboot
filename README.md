# springboot
[springboot](http://blog.didispace.com/books/spring-boot-reference/IV.%20Spring%20Boot%20features/27.1.1.%20Spring%20MVC%20auto-configuration.html)  
---
## 提交空目录  
    find . -type d -empty -exec touch {}/.gitkeep \;
---  
##Oracle 查询树
    start with sec1 connect by prior sec2 where sec3
1. 所有反馈：
    ```
    SELECT
    FEED.*
    FROM T_MEMBER_FEEDBACK FEED
    where parent_id = '-1'
    ```
2. 携带回复标识的反馈：
    ```
    SELECT 
    FEED.*,
    (select count(*) from T_MEMBER_FEEDBACK where PARENT_ID = FEED.FEEDBACK_ID) PARENT_ID_
    FROM T_MEMBER_FEEDBACK FEED
    where parent_id = '-1'
    ```
3. 查反馈 + 反馈对应的回复
    ```
    SELECT * FROM
    t_member_feedback t
    start with t.feedback_id ="123123"
    connect by prior t.feedback_id = t.PARENT_ID
    ```
    
4. 反馈 + 对应回复 -> 筛调回复
    ```
    SELECT * FROM
    t_member_feedback t
    where parent_id= '-1'
    start with t.feedback_id in(select feedback_id from t_member_feedback where parent_id = '-1')
    connect by prior t.feedback_id = t.PARENT_ID
    ```
---

# JNI
 >http://blog.csdn.net/huachao1001/article/details/53906237  
 
# IDEA External Tool
## JAVAH JNI
```
   pragram:javah
parameters:-jni -classpath $OutputPath$ -d $ProjectFileDir$/src/main/resources/jni $FileClass$
```

## GCC build DLL
```
   pragram:gcc
parameters:-Wl,--add-stdcall-alias -I"$JDKPath$\include" -I"$JDKPath$\include\win32" -shared -o $ProjectFileDir$/src/main/resources/jni/$FileNameWithoutExtension$.dll $ProjectFileDir$/src/main/resources/jni/$FileNameWithoutExtension$.cpp

#IDEA VM options
```
## Run configurations
```
-Djava.library.path=E:\workspace\StudyJNI\lib
```

#JS
```javascript
 function unique(array){
 	var n = []; //一个新的临时数组 
 	//遍历当前数组 
 	for(var i = 0; i < array.length; i++){ 
 	//如果当前数组的第i已经保存进了临时数组，那么跳过， 
 	//否则把当前项push到临时数组里面 
 	if (n.indexOf(array[i]) == -1) n.push(array[i]); 
 	} 
 	return n; 
 }
 
 function removeMember(id){
 	var index = this.indexOf(val);
 	if (index > -1) {
 		this.splice(index, 1);
 	}
 }
```
http://blog.didispace.com/books/spring-boot-reference/IV.%20Spring%20Boot%20features/29.1.1.%20Embedded%20Database%20Support.html

### Markdown

https://wizardforcel.gitbooks.io/markdown-simple-world/content/2.html
https://morrowind.gitbooks.io/gitbook_notes/content/GitBook/markdown_syntax.html
http://ibruce.info/2013/11/26/markdown/
https://wastemobile.gitbooks.io/gitbook-chinese/content/
