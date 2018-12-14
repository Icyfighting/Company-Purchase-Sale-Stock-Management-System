<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>企业进销存管理系统</title>
<link rel="stylesheet" href="themes/default/easyui.css" />
<link rel="stylesheet" href="themes/icon.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
.footer {
	text-align: center;
	color: gray;
	font-weight: bold;
	line-height: 28px;
	background-color: #E6EFFF;
}

#titSpan a {
	color: white;
	text-decoration: none;
}

#titSpan a:hover {
	color: orange;
}
</style>

<script type="text/javascript">
	$(function() {
		// 安全退出
		$("#quit").click(function() {
			$.messager.confirm("确认", "确认退出吗?", function(r) {
				if (r) {
					// 跳转到登录页面
					window.location.href = "login?method=quit";
				}
			});
		});

		// 显示修改密码的窗口
		$("#updPwd").click(function() {
			$("#pwdWin").window("open");
			$("#pwdWin input").val("");
		});

		// 取消密码修改
		$("#pwdCanc").click(function() {
			$("#pwdWin").window("close");
		});

		// 修改密码
		$("#pwdConf").click(
				function() {
					if ($(":password:eq(0)").val() == "") {
						$.messager.alert("警告", "请输入初始密码!", "warning");
					} else if ($(":password:eq(1)").val() == "") {
						$.messager.alert("警告", "请输入新的密码!", "warning");
					} else if ($(":password:eq(2)").val() == "") {
						$.messager.alert("警告", "请输入确认密码!", "warning");
					} else if ($(":password:eq(2)").val() != $(
							":password:eq(1)").val()) {
						$.messager.alert("错误", "两次密码输入不一致!", "error");
					} else {
						$.get("login", {
							"id" : "${sessionScope.user.id}",
							"opwd" : $(":password:eq(0)").val(),
							"npwd" : $(":password:eq(1)").val(),
							"method" : "updPwd"
						}, function(data) {
							if (data == "true") {
								$("#pwdWin").window("close");
								$.messager.show({
									"title" : "系统消息",
									"msg" : "密码修改成功!<br />您当前的密码为:"
											+ $(":password:eq(1)").val(),
									"timeout" : 2000,
									"showType" : "slide"
								});
							} else if (data == "false") {
								$.messager.show({
									"title" : "系统消息",
									"msg" : "密码修改失败!<br />初始密码错误!",
									"timeout" : 2000,
									"showType" : "slide"
								});
							}
						});
					}
				});

		// 点击树状菜单时的操作
		$(".easyui-tree")
				.tree(
						{
							"onClick" : function(node) {
								if (node.attributes == null
										|| node.attributes.url == null) {
									// 结束程序
									return;
								}
								var has = $("#tabMain").tabs("exists",
										node.text);
								if (has) {
									// 已经有该选项卡了, 选中即可
									$("#tabMain").tabs("select", node.text);
								} else {
									// 没有该选项卡, 在主窗口中添加新的选项卡
									$("#tabMain")
											.tabs(
													"add",
													{
														"title" : node.text,
														"closable" : true,
														"selected" : true,
														"content" : "<iframe src='"
																+ node.attributes.url
																+ "' style='width:100%; height:98%' frameborder='0'></iframe>"
													});
								}
							}
						});
	});
</script>
</head>

<body class="easyui-layout">
	<!-- 北: 顶部 -->
	<div data-options="region:'north', border: false"
		style="height: 30px; background: url('images/layout-browser-hd-bg.gif') repeat-x center;">
		<span style="margin-left: 10px;"> <img src="images/blocks.gif"
			style="margin-top:4px;" width="20" alt="" />&nbsp; <font size="4"
			color="white">造化钟神秀贸易有限公司-进销存管理系统</font>
		</span> <span id="titSpan"
			style="float: right; color: white; line-height: 30px; margin-right: 10px;">
			欢迎 ${sessionScope.user.name } 登录&nbsp;&nbsp; <a id="updPwd"
			href="javascript:void(0);">修改密码</a> | <a id="quit"
			href="javascript:void(0);">安全退出</a>
		</span>
	</div>
	<!-- 南: 底部 -->
	<div data-options="region:'south'" style="height: 30px;">
		<div class="footer">&copy; 2008-2018 北京尚学堂304班造化钟神秀组所有 侵权必究</div>
	</div>
	<%-- <!-- 西: 左边 -->
	<div data-options="region:'west', title:'系统菜单', split:true" style="width: 200px;">
		<div class="easyui-accordion" data-options="fit:true, border:false">
			<c:forEach items="${sessionScope.menus }" var="m">
				<div data-options="title:'${m.name }'">
					<ul class="easyui-tree">
						<c:forEach items="${m.children }" var="c">
							<li data-options="attributes:{'url':'${c.url }'}"><span>${c.name }</span></li>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div> --%>
	<!-- 西: 左边 -->
	<div data-options="region:'west', title:'系统菜单', split:true"
		style="width: 200px;">
		<div class="easyui-accordion" data-options="fit:true, border:false,selected:true">
			<c:forEach items="${sessionScope.menus }" var="m">
				<div data-options="title:'${m.name }'">
					<ul class="easyui-tree">
						<c:forEach items="${m.children }" var="c">
							<c:if test="${c.url == null}">
								<li><span>${c.name }</span>
								<ul>
									<c:forEach items="${c.children}" var="g">
										<li data-options="attributes:{'url':'${g.url }'}"><span>${g.name }</span></li>
									</c:forEach>
								</ul>
								</li>
							</c:if>
							<c:if test="${c.url !=null}">
							<li data-options="attributes:{'url':'${c.url }'}"><span>${c.name }</span></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- 中间 -->
	<div data-options="region:'center'">
		<div id="tabMain" class="easyui-tabs"
			data-options="fit:true, border:false">
			<div data-options="title:'首页'">
				<div style="text-align: center; overflow: hidden;">
					<img src="images/welcome.png" height="568px" />
				</div>
			</div>
		</div>
	</div>
	<!-- 修改密码的窗口 -->
	<div id="pwdWin" class="easyui-window"
		data-options="modal:true, collapsible:false, minimizable:false, maximizable:false, closed:true"
		title="修改密码" style="width:300px; height:150px">
		<table style="text-align: center; margin-left: 25px;">
			<tr>
				<td>初始密码:</td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td>新的密码:</td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><a id="pwdConf" href="javascript:void(0);"
					class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确认</a> <a
					id="pwdCanc" href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'">取消</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
