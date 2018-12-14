<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加客户信息</title>
<link rel="stylesheet" href="themes/default/easyui.css" />
<link rel="stylesheet" href="themes/icon.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />

<style type="text/css">

#father{
width:100%;
margin-left:100px;
margin-top:60px;
}

</style>
<script type="text/javascript">
	$(function() {
		$("#btnSave").click(function() {
			// 转换为ajax提交
			$("form").form({
				"url":"insSupplier",
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
				"success":function(data) {
					var msg = "";
					if(data == "true") {
						$("form").get(0).reset();
						msg = "新增成功!";
					} else {
						msg = "新增失败!";
					}
					$.messager.show({
						"title" : "系统消息",
						"msg" : msg,
						"timeout" : 2000,
						"showType" : "slide"
					});
				}
			});
			
			$("form").submit();
		});
	});
	
	function checkFields(){
		 var t = $('#form').serializeArray();//ajax中other方法，提供表单序列化
		 var flag=true;
		 $.each(t, function() {
		      //alert(this.value);
		      if(this.value==""){
		    	 flag&=false;
		      }
		    });
		 flag=flag==0?false:true;
		 //alert(flag);
		 return flag;
		  
	}
</script>
</head>

<body>
<div id="father">
	<form id="form" action="insSupplier" method="post">
		<table width="60%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" >
											<table width="100%" border="0" cellpadding="4" cellspacing="1" class="CContent">
												<tr>
													<th class="tablestyle_title">供应商信息添加</th>
												</tr>

												<tr>
													<td class="font42">
														<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
															<tr>
																<td width="100%">
																	<fieldset style="height:100%;">
																		<legend>供应商信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
																			<input type="hidden" name="method" value="insSupplier" />
																			<tr>
																				<td>供应商全称 :</td>
																				<td><input name="name" type="text" class="text" style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>地址:</td>
																				<td><input class="text" type="text" name="address" style="width:500px" value="" /></td>
																			</tr>

																			<tr>
																				<td>简称:</td>
																				<td><input class="text" name='sname' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																					<td>邮政编码:</td>
																				<td><input class="text" name='zipcode' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>电话:</td>
																				<td><input class="text" name='phone' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>传真:</td>
																				<td><input class="text" name='fax' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>联系人:</td>
																				<td><input class="text" name='contact' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>联系人电话:</td>
																				<td><input class="text" name='contactPhone' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>电子信箱:</td>
																				<td><input class="text" name='email' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>开户银行:</td>
																				<td><input class="text" name='bank' style="width:500px" value="" /></td>
																			</tr>
																			<tr>
																				<td>银行账号:</td>
																				<td><input class="text" name='accountNumber' style="width:500px" value="" /></td>
																			</tr>
																			<!-- <tr>
																				<td>客户简述:</td>
																				<td colspan="3"><textarea name="remark" cols="100" rows="8"></textarea></td>
																			</tr> -->
																			
																		</table>
																		<br />
																	</fieldset>
																</TD>

															</TR>

														</table>
													</td>
													<TR>
														<TD colspan="2" align="center" height="50px"><a href="javascript:void(0);" class="easyui-linkbutton" id="btnSave" data-options="iconCls:'icon-ok'">保存</a></TD>
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