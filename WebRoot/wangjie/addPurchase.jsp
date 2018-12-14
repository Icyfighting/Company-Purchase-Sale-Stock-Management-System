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
		
		
		$("#productId").combobox({
			url : 'product?method=selAllProduct',
			valueField : 'id',
			textField : 'name',
			editable : false
		});
		
		//供应商下拉列表
		$("#supplierId").combobox({
			url : 'product?method=selAllSupplier',
			valueField : 'id',
			textField : 'name',
			editable : false
		});
		$("#price").change(function(){
			var num=$("#number").val();
			var price=$("#price").val();
			$("#totalAmount").val(num*price);
		});
		$("#number").change(function(){
			var num=$("#number").val();
			var price=$("#price").val();
			$("#totalAmount").val(num*price);
		});
		
		
		$("#btnSave").click(function() {
			// 转换为ajax提交
			$("form").form({
				"url":"addpurchase",
				"onSubmit":function(){
					//提交前的判断，各个字段不能为空
					if (!checkFields()) {
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
</head>

<body>
	<form action="addpurchase" id="form" method="post">
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
													<th class="tablestyle_title">商品采购</th>
												</tr>

												<tr>
													<td class="font42">
														<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
															<TR>
																<TD width="100%">
																	<fieldset style="height:100%;">
																		<legend>商品采购信息</legend>
																		<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
																			<input type="hidden" name="method" value="AddPurchase" />
																			<tr>
																				<td>商品名称:</td>
																				<td><input id="productId" name="productId" style="width:156px;" value="请选择" /></td>
																			</tr>
																			<tr>
																				<td>供应商名称:</td>
																				<td><input id="supplierId" name="supplierId" style="width:156px;" value="请选择" /></td>
																			</tr>
																			<tr>
																				<td>采购日期:</td>
																				<td> 
																					<input name='pdate' class="easyui-datebox" data-options="editable:false" style="width:156px" />
																				</td>
																			</tr>
																			<tr>
																				<td>采购数量 :</td>
																				<td><input id="number" name="number" type="text" class="operator" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>单价 :</td>
																				<td><input id="price" name="price" type="text" class="brokerage" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>总金额 :</td>
																				<td><input id="totalAmount" name="totalAmount" type="text" class="settlement" style="width:154px" value="" /></td>
																			</tr>
																			<tr>
																				<td>备注:</td>
																				<td><input class="remark" type="text" name="remark" style="width:154px" value="" /></td>
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