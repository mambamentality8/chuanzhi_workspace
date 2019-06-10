<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String admin=(String)session.getAttribute("user");  
String sf=(String)session.getAttribute("sf");  
%>
<link rel="stylesheet" href="<%=basePath %>images/css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath %>images/css/css.css" />
<script type="text/javascript" src="<%=basePath %>images/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/sdmenu.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/laydate/laydate.js"></script>
 
<div class="header">
<div class="logo" style="width:600px;"><p style="font-size:24px;color:#333; font-family:Arial, Helvetica, sans-serif;margin-top:20px; margin-left:100%;width:300px;">小型医院住院管理系统</p></div>
<div class="header-right"><font>用户：<%=admin %>  身份：<%=sf %></font><a href="<%=basePath%>index.jsp" target="_top"> </a>
<i class="icon-off icon-black"></i> <a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="<%=basePath %>AdminServlet?method=adminexit" target="_top">退出</a> 
<div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%"> 
</div>
</div>
</div>