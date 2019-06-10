<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
执行成功！
${msg}<%--表示从四大域中，由小到大逐个搜索  page  request session application --%>
<hr/>
${requestScope.msg}<%--明确指定从请求域搜索--%>
</body>
</html>
