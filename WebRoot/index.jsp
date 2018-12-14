<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>登录</title>
<!-- 引入两个css -->
<!-- 使用EasyUI提供的某个主题 -->
<link rel="stylesheet" href="themes/default/easyui.css" />
<!-- 使用EasyUI提供的图标样式 -->
<link rel="stylesheet" href="themes/icon.css" />
<!-- 引入两个js -->
<!-- jquery的支持 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- easyui的支持 -->
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<style type="text/css">
.icon-mylogin {
	background:url('images/login.png') no-repeat center center;
}

tr {
	height: 30px;
}
</style>
<script type="text/javascript">
	$(function() {
		// 点击登录按钮的操作
		$("#btnSub").click(function() {
			if($(":text").val() == "") {
				$.messager.alert("警告", "用户名不能为空!", "warning");
			} else if($(":password").val() == "") {
				$.messager.alert("警告", "密码不能为空!", "warning");
			} else {
				// 登录成功, 提交表单
				$("form").submit();
			}
		});
		// 点击重置按钮的操作
		$("#btnRes").click(function() {
			// jquery中没有reset方法
			$("form").get(0).reset();
		});
	});
</script>
</head>
<body style="background-color: #eee;">
	<div style="width: 400px; margin: 100px auto;">
		<div id="p" class="easyui-panel" title="登录"
	        style="width:400px;height:200px;padding:10px;background:#fafafa;text-align: center"   
	        data-options="iconCls:'icon-mylogin'">   
		    <form action="login" method="post" style="margin-left: 80px; margin-top: 20px">
		    		<input type="hidden" name="method" value="login" />
		    		<input type="hidden" value="login" name="method" />
		    	<table>
		    		<tr>
		    			<td>用户名:</td>
		    			<td><input type="text" name="uname" /></td>
		    		</tr>
		    		<tr>
		    			<td>密　码:</td>
		    			<td><input type="password" name="upwd" /></td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">
							<a id="btnSub" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a>
							<a id="btnRes" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
						</td>
		    		</tr>
		    	</table>
		    </form>
		    <font color="red" size="4">${sessionScope.msg }</font>
		    <c:remove var="msg" scope="session"></c:remove>
		</div>
	</div>
</body>
</html>