<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" rev="stylesheet" href="css/style.css"
	type="text/css" media="all" />
<title>添加用户</title>

<script type="text/javascript">
	$(function() {
		$("#roleId").combobox({
			url : 'role?method=selRole',
			valueField : 'id',
			textField : 'name',
			editable : false
		});

		$("#btnSave").click(function() {
			//转换为ajax提交
			$("form").form({
				"url" : "user",
				"onSubmit": function(){
					//提交前的判断，各个字段不能为空
					if(!checkFields()){
						msg = "每个字段都不能为空!";
						$.messager.show({
							"title" : "系统消息",
							"msg" : msg,
							"timeout" : 2000,
							"showType" : "slide"
						});
						return false;
					}
					return true;
				},
				"success" : function(data) {
					var msg = "";
					if (data == "true") {
						msg = "新增成功";
						$("form").get(0).reset();
					} else {
						msg = "新增失败";
					}
					$.messager.show({
						"title" : "系统消息",
						"msg" : msg,
						"timeout" : 2000,
						"showType" : "slide"
					});
				}

			});
			$("#form").submit();
		});

	});
	
	function checkFields() {
		var t = $('#form').serializeArray();//ajax中other方法，提供表单序列化
		var flag = true;
		$.each(t, function() {
			//alert(this.value);
			if (this.value == "") {
				flag &= false;
			}
		});
		flag = flag == 0 ? false : true;
		//alert(flag);
		return flag;

	}
</script>
<style type="text/css">

#father{
width:50%;
margin-top:150px;
margin-left:200px;


}

</style>

</head>

<body>
	<div id="father" >
		<form action="user" id="form" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table id="subtree1" style="DISPLAY: " width="100%" border="0"
							cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<table width="95%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4"
													cellspacing="1" class="CContent">
													<tr>
														<th class="tablestyle_title">添加用户信息</th>
													</tr>

													<tr>
														<td class="font42">
															<table border="0" cellpadding="0" cellspacing="0"
																style="width:100%">
																<TR>
																	<TD width="100%">
																		<fieldset style="height:100%;">
																			<legend>用户信息</legend>
																			<table border="0" cellpadding="2" cellspacing="1"
																				style="width:100%">
																				<input type="hidden" name="roleId" value="1" />
																				<input type="hidden" name="method" value="insUser" />
																				<tr>
																					<td>用户名称 :</td>
																					<td><input name="name" type="text"
																						class="text" style="width:154px" value="" /></td>
																				</tr>
																				<tr>
																					<td>真实姓名:</td>
																					<td><input name="rname" type="text"
																						class="text" style="width:154px" value="" /></td>
																				</tr>
																				<tr>
																					<td>用户密码:</td>
																					<td><input class="text" type="password"
																						name="pwd" style="width:154px" value="" /></td>
																				</tr>

																				<tr>
																					<td>角色:</td>
																					<td><input id="roleId" name="roleId_1"
																						style="width:156px;" value="" /></td>
																				</tr>


																			</table>
																			<br />
																		</fieldset>
																	</TD>

																</TR>

															</table>
														</td>
													<TR>
														<TD colspan="2" align="center" height="50px"><a
															href="javascript:void(0);" class="easyui-linkbutton"
															id="btnSave" data-options="iconCls:'icon-ok'">保存</a></TD>
													</TR>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						</form>
						</div>
</body>
</html>
