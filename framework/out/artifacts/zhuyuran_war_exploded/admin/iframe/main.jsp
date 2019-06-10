<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<jsp:useBean id="cb" scope="page" class="com.bean.ComBean" /> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=basePath %>images/css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath %>images/css/css.css" />
<script type="text/javascript" src="<%=basePath %>images/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/sdmenu.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/laydate/laydate.js"></script>
</head>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
			message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");
%>
<%
	String username=(String)session.getAttribute("user");
	if(username==null){
		response.sendRedirect(basePath+"/error.jsp");
	}
	else{ 
%>
<body>
<div class="right_cont" style="border:none;">
<div class="title_right" style="font-size:16px;margin-left:100px;"><strong>欢迎使用小型医院住院管理系统！</strong></div>  
<div style="width:900px;margin:auto;"> 
 <%
 	List brlist=cb.getCom("select * from ap order by id desc",13); 
 	if(!brlist.isEmpty()){
 		for(int i=0;i<brlist.size();i++){
 		List list2=(List)brlist.get(i);
 		float yj=Float.parseFloat(list2.get(7).toString());
 		float jf=cb.getFloat("select sum(je) from jf where bh='"+list2.get(8).toString()+"'");
		float xf=cb.getFloat("select sum(je) from xf where bh='"+list2.get(8).toString()+"'"); 
		float ye=yj+jf-xf;
		cb.comUp("update ap set jf='"+jf+"', xf='"+xf+"', ye='"+ye+"' where  bh='"+list2.get(8).toString()+"'");
 	}}
 %> 
 
   </div>  
 </div>  
</body>
<%} %>
 
