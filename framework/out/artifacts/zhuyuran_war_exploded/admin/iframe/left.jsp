<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=basePath %>images/css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath %>images/css/css.css" />
<script type="text/javascript" src="<%=basePath %>images/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/sdmenu.js"></script>
<script type="text/javascript" src="<%=basePath %>images/js/laydate/laydate.js"></script>
</HEAD>
<%
	String username=(String)session.getAttribute("user");  String sf=(String)session.getAttribute("sf");  
	if(username==null){
		response.sendRedirect(path+"index.jsp");
	}
	else{ 
%>
<body>
<div class="left">
     
<script type="text/javascript">
var myMenu;
window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

<div id="my_menu" class="sdmenu">

	<div class="collapsed">
		<span>密码信息管理</span>
		<a href="<%=basePath %>admin/system/editpwd.jsp" target="MainFrame">密码修改</a> 
	</div>
	<%if(sf.equals("管理员")){ %>
	<div class="collapsed">
		<span>系统用户管理</span>
		<a href="<%=basePath %>admin/system/index.jsp" target="MainFrame">系统用户管理</a> 
		<a href="<%=basePath %>admin/system/add.jsp?method=addm" target="MainFrame">添加系统用户</a> 
		 <a href="<%=basePath %>admin/system/s.jsp" target="MainFrame">系统用户查询</a>  
	</div> 
	
	<div class="collapsed">
		<span>科室信息管理</span>
		<a href="<%=basePath %>admin/bf/index.jsp" target="MainFrame">科室管理</a> 
		<a href="<%=basePath %>admin/bf/add.jsp?method=addbf" target="MainFrame">添加科室信息</a> 
		 <a href="<%=basePath %>admin/bf/s.jsp" target="MainFrame">科室信息查询</a>  
	</div>   
	
	<div class="collapsed">
		<span>床位信息管理</span>
		<a href="<%=basePath %>admin/cw/index.jsp" target="MainFrame">床位信息管理</a> 
		<a href="<%=basePath %>admin/cw/add.jsp?method=addcw" target="MainFrame">添加床位信息</a> 
		 <a href="<%=basePath %>admin/cw/s.jsp" target="MainFrame">床位信息查询</a>  
	</div> 



	<div class="collapsed">
		<span>病人信息管理</span>
		<a href="<%=basePath %>admin/ap/index.jsp" target="MainFrame">病人信息管理</a> 
		<a href="<%=basePath %>admin/ap/add.jsp?method=addap" target="MainFrame">添加病人信息</a>  
		<a href="<%=basePath %>admin/ap/s.jsp" target="MainFrame">病人信息查询</a> 
	</div>  
	<div class="collapsed">
		<span>出院管理</span>
		<a href="<%=basePath %>admin/chu/index.jsp" target="MainFrame">出院管理</a>   
		<a href="<%=basePath %>admin/chu/s.jsp" target="MainFrame">出院查询</a> 
	</div> 
 	<div class="collapsed">
		<span>病历管理</span>
		<a href="<%=basePath %>admin/wh/index.jsp" target="MainFrame">病历管理</a> 
		<a href="<%=basePath %>admin/wh/add.jsp?method=addwh" target="MainFrame">添加病历</a> 
		 <a href="<%=basePath %>admin/wh/s.jsp" target="MainFrame">病历查询</a>  
	</div>
	<div class="collapsed">
		<span>交费管理</span>
		<a href="<%=basePath %>admin/jf/index.jsp" target="MainFrame">交费管理</a> 
		<a href="<%=basePath %>admin/jf/add.jsp?method=addjf" target="MainFrame">添加费用</a> 
		 <a href="<%=basePath %>admin/jf/s.jsp" target="MainFrame">交费查询</a>  
	</div>
	<div class="collapsed">
		<span>消费管理</span>
		<a href="<%=basePath %>admin/xf/index.jsp" target="MainFrame">消费管理</a> 
		<a href="<%=basePath %>admin/xf/add.jsp?method=addxf" target="MainFrame">添加消费</a> 
		 <a href="<%=basePath %>admin/xf/s.jsp" target="MainFrame">消费查询</a>  
	</div>
	
	<div class="collapsed">
		<span>余额管理</span>
		<a href="<%=basePath %>admin/xf/bj.jsp" target="MainFrame">余额不足管理</a>  
	</div>
	<%}else{ %>
	<div class="collapsed">
		<span>病人信息查询</span> 
		<a href="<%=basePath %>admin/ap/s2.jsp" target="MainFrame">病人信息查询</a> 
	</div>  
 	<div class="collapsed">
		<span>病历查询</span> 
		 <a href="<%=basePath %>admin/wh/s2.jsp" target="MainFrame">病历查询</a>  
	</div>
	<div class="collapsed">
		<span>交费查询</span> 
		 <a href="<%=basePath %>admin/jf/s2.jsp" target="MainFrame">交费查询</a>  
	</div>
	<div class="collapsed">
		<span>消费查询</span> 
		 <a href="<%=basePath %>admin/xf/s2.jsp" target="MainFrame">消费查询</a>  
	</div>
	<%} %>
 	<div class="collapsed">
		<span>退出系统</span>
		<a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="<%=basePath %>AdminServlet?method=adminexit" target="_top" >退出系统</a>
	</div> 
</div>
     </div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script> 
</body>
<%} %>

</html>
