<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%> 
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
<script type="text/javascript">
function check()
{
	if(document.form1.word.value=="" )
	{
		alert("����д��ѯ�ؼ��֣�");
		document.form1.word.focus();
		return false;
	}
}
</script>
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
<div class="right_cont" style="width:550px;">
<div class="title_right" style="background:#e5f9fc;"><strong>������Ϣ��ѯ</strong></div>  
<div style="width:550px;margin:auto;">
<form action="<%=basePath %>admin/xf/sinfo.jsp" method="post" name="form1">
<table class="table table-bordered">
	 <tr>
     <td width="40%" align="right" nowrap="nowrap">���˱�ţ�</td>
     <td><input type="text" name="word" class="span3" required/></td> 
     </tr> 
     <tr>
     	<td class="text-center" colspan="2"><input type="submit" value="�ύ" class="btn btn-info  " style="width:80px;height:25px;line-height:10px;border-radius:5px;box-shadow:1px 1px 1px 1px rgba(0,0,0,.1);background:#e1e8e1;color:#333;" /></td>
     </tr>
     </table> 
</form>
   </div>  
 </div>  
</body>
<%} %>
 