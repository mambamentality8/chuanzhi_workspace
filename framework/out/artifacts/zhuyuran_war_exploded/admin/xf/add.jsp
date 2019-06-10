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
		String bh="";String xm="";;String je="";String sj=""; 
		if(method.equals("upxf")){
			id=request.getParameter("id");
			List alist=cb.get1Com("select * from xf where id='"+id+"'",5);
			bh=alist.get(1).toString();
			xm=alist.get(2).toString();
			je=alist.get(3).toString();
			sj=alist.get(4).toString(); 
		}
%>
<body>
<div class="right_cont" style="width:550px;">
<div class="title_right" style="background:#e5f9fc;"><strong>添加消费</strong></div>  
<div style="width:550px;margin:auto;">
<form action="<%=basePath %>ComServlet?method=<%=method%>&id=<%=id%>" method="post" name="form1">
<table class="table table-bordered">
	 <tr>
     <td width="30%" align="right" nowrap="nowrap" >病人编号：</td>
     <td><select name="bh">
    <%if(method.equals("upxf")){ %><option value="<%=bh%>"><%=bh%></option> <%} %> 
    <%List flist=cb.getCom("select * from ap where zt='未出院' order by id asc",9);if(!flist.isEmpty()){for(int i=0;i<flist.size();i++){List list2=(List)flist.get(i);%>
    <option value=<%=list2.get(8).toString() %>><%=list2.get(8).toString() %></option>
    <%}} %>
    </select></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >消费名称：</td>
     <td><select name="xm">
    <%if(method.equals("upxf")){ %><option value="<%=xm%>"><%=xm%></option> <%} %>  
    <option value="床位费">床位费</option> 
    <option value="护工费">护工费</option> 
    <option value="诊疗费">诊疗费</option> 
    </select></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >消费金额：</td>
     <td><input type="number" name="je" class="span4" value="<%=je %>" required/></td> 
     </tr> 
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >消费时间：</td>
     <td><input type="date" name="sj" class="span4" value="<%=sj %>" required/></td> 
     </tr>   
     <tr>
     	<td class="text-center" colspan="2"><input type="submit" value="确定" class="btn btn-info  " style="width:80px;height:25px;line-height:10px;border-radius:5px;box-shadow:1px 1px 1px 1px rgba(0,0,0,.1);background:#e1e8e1;color:#333;" /></td>
     </tr>
     </table> 
</form>
   </div>  
 </div>  
</body>
<%} %>