<%@page pageEncoding="UTF-8" language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<!-- 1、ModelAttribute的使用-->
<%--
<a href="springmvc/testModelAttribute">测试ModelAttribute</a>
修改用户：已经从数据库中查询出来的用户信息了
<form action="springmvc/updateUser" method="post">
    <input type="hidden" name="id" value="1">
    用户名：<input type="text" name="username" value="泰斯特"><br/>
    年龄：<input type="text" name="age" value="18"><br/>
    性别：<input type="text" name="gender" value="男"><br/>
    <input type="submit" value="修改">
</form>修改用户：已经从数据库中查询出来的用户信息了
<hr/>
--%>
<%--2、SessionAttributes的使用
<a href="springmvc/testPut">存入会话域</a>
<a href="springmvc/testGet">从会话域取出</a>
<a href="springmvc/testClean">清除会话域</a>
<hr/>--%>

<%--3、控制器方法的返回值
<a href="springmvc/testReturnString">测试返回值是String类型</a>
<a href="springmvc/testReturnVoid">测试返回值是Void类型</a>
<a href="springmvc/testReturnModelAndView">测试返回值是ModelAndView类型</a>
--%>

<%--4、交互json格式数据
<script type="text/javascript" src="/day55_ee69_01springmvc_anno/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
       $("#testAjax").click(function () {
           alert("绑定点击事件成功了");
           $.ajax({
               url:"springmvc/testJson",//请求的地址
               type:"POST",//请求的方式
               data:'{"username":"张三","age":18,"gender":"男"}',//请求的数据
               contentType:"application/json",//指定请求正文的类型（MIME类型）
               dataType:"json",//预计的响应数据类型
               success:function (data) {//执行成功后的回调函数
                   alert(data);//此时打印出来的是object，表示是json对象，如果是{"":""}则就是文本
                   alert(data.age);
               }
           });
       });
    });
</script>
<a href="#" id="testAjax">异步请求，提交数据</a>
<a href="springmvc/testJson?username=泰斯特&age=18&gender=男">测试请求参数</a>
--%>

<%--5、PathVaribale注解的使用
<form action="springmvc/deleteUser/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除用户">
</form>
--%>

<%--6、文件上传--%>
<form action="springmvc/fileupload1" method="post" enctype="multipart/form-data">
    照片：<input type="file" name="uploadFile" >
    <input type="submit" value="上传">
</form>
</body>
</html>
