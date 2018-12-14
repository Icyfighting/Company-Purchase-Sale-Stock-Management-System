<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="themes/default/easyui.css" />
<link rel="stylesheet" href="themes/icon.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<title>修改密码</title>
  
<script type="text/javascript">
  $(function(){
	  
	  
	  //取消密码修改
	  $("#pwdCanc").click(function(){
		
	  });
	 
	 //修改密码
	 $("#pwdConf").click(function(){
		// alert("test");
		 if($(":password:eq(0)").val()==""){
			 $.messager.alert("警告","请输入初始密码！","warning");
		 }else if($(":password:eq(1)").val()==""){
			 $.messager.alert("警告","请输入新密码!","warning");
		 }else if($(":password:eq(2)").val()==""){
			 $.messager.alert("警告","请确认密码","warning");
		 }else if($(":password:eq(2)").val()!=$(":password:eq(1)").val()){
			 $.messager.alert("警告","两次密码输入不一致!","error");
		 }else{
			 $.get("login",{
				 "id":"${sessionScope.user.id}",
				 "opwd":$(":password:eq(0)").val(),
				 "npwd":$(":password:eq(1)").val(),
				 "method":"updPwd"
			 },function(data){
				 if(data=="true"){
					 $.messager.show({
						 "title":"系统消息",
						 "msg":"密码修改成功！<br/>您当前的密码为："+$(":password:eq(1)").val(),
						 "timeout":2000,
						 "showType":"slide"
					 });
				 }else if(data=="false"){
					 $.messager.show({
						 "title":"系统消息",
					     "msg":"密码修改失败!<br />初始密码错误！",
					     "timeout":2000,
					     "showType":"slide"
					 });
				 }
			 });
		 }
	
	 });
	 
	 
  });

</script>
<style type="text/css">

#pwdWin{
width:100%;
margin-left:300px;
margin-top:150px;
}

table{
width:400px;

border-collapse: collapse;
}

td {
	border: 1px solid gray;

}

</style>

</head>
   
<body>

   <!-- 修改密码窗口 -->
   <div id="pwdWin"  title="修改密码" style="width:300px; height:150px">
       <table  >
       <caption
						style="background-color: #6795B4; height: 30px; line-height: 30px; color: white; border: 1px solid gray; border-bottom: none;">修改当前用户密码</caption>
       
          <tr>
          	<td>用户名</td>
          	<td><input class="text" name='name' 
							value="${sessionScope.user.name }" readonly /></td>
          </tr>
          <tr>
          	<td>真实姓名</td>
          	<td><input class="text" name='rname' 
							value="${sessionScope.user.rname }" readonly /></td>
          </tr>
          <tr>
          	<td>角色</td>
          	<td><input class="text" name='roleName' 
							value="${sessionScope.user.roleName }" readonly /></td>
          </tr>
          <tr>
          	<td>初始密码</td>
          	<td><input type="password" /></td>
          </tr>
          <tr>
          	<td>新的密码</td>
          	<td><input type="password" /></td>
          </tr>
          <tr>
          	<td>确认密码</td>
          	<td><input type="password" /></td>
          </tr>
          <tr>
          	<td colspan="2" align="center" height="50px">
          	   <a id="pwdConf" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确认</a>
          	   <a id="pwdCanc" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
          	</td>
          </tr>           
       </table>
   </div>
</body>
</html>
