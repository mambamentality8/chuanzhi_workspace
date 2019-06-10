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
		String cw="";String xm="";String xb="";String zd="";String dh="";String zsj="";String csj="";String bh=String.valueOf(System.currentTimeMillis()); 
		if(method.equals("upap")){
			id=request.getParameter("id");
			List alist=cb.get1Com("select * from ap where id='"+id+"'",9);
			cw=alist.get(1).toString();
			xm=alist.get(2).toString();
			xb=alist.get(3).toString();
			zd=alist.get(4).toString();
			dh=alist.get(5).toString(); 
			zsj=alist.get(6).toString(); 
			csj=alist.get(7).toString(); 
			bh=alist.get(8).toString(); 
		}
%>
<body>
<div class="right_cont" style="width:500px;">
<div class="title_right" style="background:#e5f9fc;"><strong>添加病人信息</strong></div>  
<div style="width:500px;margin:auto;">
<form action="<%=basePath %>ComServlet?method=<%=method%>&id=<%=id%>" method="post" name="form1">
<table class="table table-bordered" style="height：400px;">
	 <tr>
     <td width="30%" align="right" nowrap="nowrap" >病历编号：</td>
     <td><input type="text" name="bh" class="span4" value="<%=bh %>" readonly/></td> 
     </tr>
	 <tr>
     <td width="30%" align="right" nowrap="nowrap" >床位：</td>
     <td><select name="cw">
    <%if(method.equals("upap")){ %><option value="<%=cw%>"><%=cw%></option> <%} %> 
    <%List flist=cb.getCom("select * from cw order by id asc",2);if(!flist.isEmpty()){for(int i=0;i<flist.size();i++){List list2=(List)flist.get(i);%>
    <option value=<%=list2.get(1).toString() %>><%=list2.get(1).toString() %></option>
    <%}} %>
    </select></td> 
     </tr> 
	 <tr>
     <td width="30%" align="right" nowrap="nowrap" >姓名：</td>
     <td><input type="text" name="xm" class="span4" value="<%=xm %>" required/></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap" >性别：</td>
     <td><INPUT type="radio" name="xb" value="男" checked="checked"> 男 <input type="radio" name="xb" value="女" > 女</td> 
     </tr> 
     <tr>
     <td width="30%" align="right" nowrap="nowrap">科室：</td>
     <td><select name="zd">
    <%if(method.equals("upap")){ %><option value="<%=zd%>"><%=zd%></option> <%} %> 
    <%List kslist=cb.getCom("select * from bf order by id asc",2);if(!kslist.isEmpty()){for(int i=0;i<kslist.size();i++){List list2=(List)kslist.get(i);%>
    <option value=<%=list2.get(1).toString() %>><%=list2.get(1).toString() %></option>
    <%}} %>
    </select></td> 
     </tr>  
     <tr>
     <td width="30%" align="right" nowrap="nowrap">电话：</td>
     <td><input type="text" name="dh" class="span4" value="<%=dh %>" pattern="[0-9]{11}" title="11位手机号码" required /></td> 
     </tr>
     <tr>
     <td width="30%" align="right" nowrap="nowrap">住院原因：</td>
     <td><textarea name="zsj" class="span4" rows="5" required><%=zsj %></textarea></td> 
     </tr> 
     <tr>
     <td width="30%" align="right" nowrap="nowrap">住院押金：</td>
     <td><input type="number" name="csj" class="span4" value="<%=csj %>" required/></td> 
     </tr>   
     <tr>
     	<td class="text-center" colspan="2"><input type="submit" value="确定" class="btn btn-info  " style="height:25px;
     	line-height:10px;border-radius:5px;box-shadow:1px 1px 1px 1px rgba(0,0,0,.1);background:#e1e8e1;color:#333;" /></td>
     </tr>
     </table> 
</form>
   </div>  
 </div>  
</body>
<%} %>