<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>默认主页</title>
</head>
<body>
<!--入门案例-->
<a href="${pageContext.request.contextPath}/hello">入门案例</a>
<hr/>
<!--RequestMapping注解介绍-->
<a href="springmvc/testRequestMapping?money>1000">testRequestMapping</a>
<br/>
<form action="springmvc/testRequestMapping" method="post">
    <input type="hidden" name="money" value="1000">
    <input type="submit" value="提交">
</form>
<hr/>
<!--请求参数的封装（绑定）基本类型和String类型-->
<a href="springmvc/testParam1?name=张三&age=18">绑定基本类型和String类型的参数  GET请求</a>
<form action="springmvc/testParam1" method="post">
   用户名： <input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="POST请求绑定基本类型和String类型参数">
</form>
<hr/>
<!--请求参数的封装（绑定）实体类类型-->
<form action="springmvc/testParam2" method="post">
    用户名： <input type="text" name="name"><br/>
    金额：<input type="text" name="money"><br/>
    省份：<input type="text" name="address.provinceName"><br/>
    城市：<input type="text" name="address.cityName"><br/>
    <input type="submit" value="实体类类型参数绑定">
</form>
<hr/>
<!--请求参数的封装（绑定） 复杂类型的绑定:List集合-->
<form action="springmvc/testParam2" method="post">
    用户名： <input type="text" name="name"><br/>
    金额：<input type="text" name="money"><br/>
    省份1：<input type="text" name="addressList[0].provinceName"><br/>
    城市1：<input type="text" name="addressList[0].cityName"><br/>
    省份2：<input type="text" name="addressList[1].provinceName"><br/>
    城市2：<input type="text" name="addressList[1].cityName"><br/>
    省份3：<input type="text" name="addressList[2].provinceName"><br/>
    城市3：<input type="text" name="addressList[2].cityName"><br/>
    <input type="submit" value="实体类类型参数绑定">
</form>
<hr/>
<!--请求参数的封装（绑定） 复杂类型的绑定:Map集合-->
<form action="springmvc/testParam2" method="post">
    用户名： <input type="text" name="name"><br/>
    金额：<input type="text" name="money"><br/>
    省份1：<input type="text" name="addressMap['key1'].provinceName"><br/>
    城市1：<input type="text" name="addressMap['key1'].cityName"><br/>
    省份2：<input type="text" name="addressMap['key2'].provinceName"><br/>
    城市2：<input type="text" name="addressMap['key2'].cityName"><br/>
    省份3：<input type="text" name="addressMap['key3'].provinceName"><br/>
    城市3：<input type="text" name="addressMap['key3'].cityName"><br/>
    <input type="submit" value="实体类类型参数绑定">
</form>
<hr/>
<!-- 请求参数绑定的特殊情况：使用原始ServletAPI对象-->
<a href="springmvc/testParam3">访问原始ServletAPI对象</a>
<hr/>
<!--请求参数绑定的特殊情况：类型转换问题-->
<!--请求参数的封装（绑定）实体类类型-->
<form action="springmvc/testParam4" method="post">
    用户名： <input type="text" name="name"><br/>
    金额：<input type="text" name="money"><br/>
    创建日期：<input type="text" name="createTime"><br/>
    <input type="submit" value="类型转换">
</form>
<hr/>
<!--和消息头相关的两个注解-->
<a href="springmvc/testOtherAnnotation">RequestHeader和CookieVlaue</a>
</body>
</html>
