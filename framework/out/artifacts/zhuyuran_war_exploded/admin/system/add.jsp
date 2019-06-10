<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
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
	
	String username=(String)session.getAttribute("user"); 
	if(username==null){
		response.sendRedirect(basePath+"index.jsp");
	}
	else{
		String method=request.getParameter("method");
		String id="";
		String usernam="";String password="";String realname="";String sex="";String age="";String address="";String tel=""; 
		if(method.equals("upm")){
			id=request.getParameter("id");
			List alist=cb.get1Com("select * from admin where id='"+id+"'",10);
			usernam=alist.get(1).toString();
			password=alist.get(2).toString();
			realname=alist.get(3).toString();
			sex=alist.get(4).toString();
			age=alist.get(5).toString();
			address=alist.get(6).toString();
			tel=alist.get(7).toString(); 
		}
%>
<body>
<div class="right_cont" style="width:550px;">
<div class="title_right" style="background:#e5f9fc;" ><strong>添加系统用户</strong></div>  
<div style="width:550px;">
<form action="<%=basePath %>AdminServlet?method=<%=method%>&id=<%=id%>" method="post" name="form1">
<table class="table table-bordered" style="height:350px;">
	 <tr>
     <td width="30%" align="right" nowrap="nowrap">帐号：</td>
     <td><%if(method.equals("upm")){ %><input type="text" name="username" class="span4" value="<%=usernam %>" readonly/><%}else{ %><input type="text" class="span4" name="username" required/><% } %></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap">初始密码：</td>
     <td><input type="password" name="password" class="span4" value="<%=password %>" required/></td> 
     </tr> 
     <tr>
     <td width="30%" align="right" nowrap="nowrap">姓名：</td>
     <td><input type="text" name="realname" class="span4" value="<%=realname %>" required/></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap">性别：</td>
     <td><input type="radio" name="sex" value="男" checked="checked"/> 男 <input type="radio" name="sex" value="女"/> 女</td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >年龄：</td>
     <td><input type="number" name="age" class="span4" value="<%=age %>" required/></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >电话：</td>
     <td><input type="text" name="tel" class="span4" value="<%=tel %>" pattern="[0-9]{11}" title="11位手机号码" required /></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >地址：</td>
     <td><input type="text" name="address" class="span4" value="<%=address %>" required/></td> 
     </tr>  
     <tr>
     	<td class="text-center" colspan="2"><input type="submit" value="确定" class="btn btn-info  "  style="width:80px;height:25px;line-height:10px;border-radius:5px;box-shadow:1px 1px 1px 1px rgba(0,0,0,.1);background:#e1e8e1;color:#333;" /></td>
     </tr>
     </table> 
</form>
   </div>  
 </div>  
</body>
<%} %>