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
<title></title>
<link rel="stylesheet" href="themes/default/easyui.css" />
<link rel="stylesheet" href="themes/icon.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />

<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
<script type="text/javascript">
	$(function() {
		$("#btnSave").click(function() {
			// 转换为ajax提交
			$("form").form({
				"url":"addinstorage",
				"success":function(data) {
					var msg = "";
					if(data == "true") {
						msg = "新增成功!";
						$("form").get(0).reset();
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
</script>
</head>

<body>
	<form action="addinstorage" id="fom" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4" cellspacing="1" class="CContent">
												<tr>
													<th class="tablestyle_title">商品入库</th>
												</tr>

												<tr>
													<td class="font42">
														<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
															<TR>
																<TD width="100%">
																	<fieldset style="height:100%;">
																		<legend>商品入库信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
																			
																			<input type="hidden" name="method" value="AddInStorage" />
																			<tr>
																				<td>供应商编号 :</td>
																				<td><input name="supplierId" type="text" class="text" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>入库时间 :</td>
																				<td> 
																					<input name='idate' class="easyui-datebox" data-options="editable:false" style="width:156px" />
																				</td>
																			</tr>
																			<tr>
																				<td>操作人员 :</td>
																				<td><input name="operator" type="text" class="operator" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>经手人 :</td>
																				<td><input name="brokerage" type="text" class="brokerage" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>结算方式 :</td>
																				<td><input name="settlement" type="text" class="settlement" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>商品编号:</td>
																				<td><input class="productId" type="text" name="productId" style="width:154px" value="" /></td>
																			</tr>

																			<tr>
																				<td>单价:</td>
																				<td><input class="price" type="text"name="price" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>数量:</td>
																				<td><input class="number"type="text" name="number" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>实付:</td>
																				<td><input class="actualPay"type="text" name="actualPay" style="width:154px" value="" /></td>
																			</tr>
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
</body>

</html>