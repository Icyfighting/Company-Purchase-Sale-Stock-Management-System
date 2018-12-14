<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
table {
	margin-left:200px;
	margin-top:100px;
	width: 40%;
	border-collapse: collapse;
}

td {
	border: 1px solid gray;

}

</style>
<script type="text/javascript">
	$(function() {

		
		$("#productName").combobox({
			url : 'stock?method=selStockName',
			valueField : 'productId',//不好使的话，改回到id
			textField : 'productName',
			editable : false
		});
		
		$("#productName").combobox({
			onSelect: function(){
				var value=$('#productName').combobox('getText');      
				//alert(value);
				$.get("stock",{"method":"selByName","srchVal":value},function(data){
					//alert(data[0].productName);
					$("#form").form("load",data[0] );
				});
				//
			}
		});
		
		$("#btnUpdPrice").click(function(){
			// 转换为ajax提交
			$("#form").form('submit',{
				"url" : "stock?method=updPrice",
				"success" : function(data) {
					var msg = "";
					if (data == "true") {
						msg = "价格修改成功!";
					} else {
						msg = "价格修改失败!";
					}
					$.messager.show({
						"title" : "系统消息",
						"msg" : msg,
						"timeout" : 2000,
						"showType" : "slide"
					});
				}
			});
		});
		$("#btnCancel").click(function() {
			$("#form").form("clear");
			$("#productName").combobox("setValue", "请选择");

		});

	});
</script>
</head>



<body>

	<form id="form" method="post">
		<table id="table">
			<caption style="background-color: #6795B4; height: 30px; line-height: 30px; color: white; border: 1px solid gray; border-bottom: none;">修改商品统一售价</caption>
		
			<!-- <caption style="background-color: #6795B4; height: 30px; line-height: 30px; color: white; border: 1px solid gray; border-bottom: none;">添加商品信息</caption> -->
		
			<!-- 	<input type="hidden" name="roleId" value="1" /> -->
			<!-- <input type="hidden" name="method" value="chgPrice" /> -->
			<tr>
				<td>商品名称：</td>
				<td><input id="productName" name="productName" style="width:156px;" value="请选择" /></td>
					
			</tr>
			<tr>
				<td>商品编号：</td>
				<td><input class="text" name="productId" style="width:154px;" value="" readOnly /></td>
					
			</tr>
			<tr>
				<td>产品简称:</td>
				<td><input class="text" name='sname' style="width:154px"
					value="" readOnly  /></td>
			</tr>
			<tr>
				<td>产地:</td>
				<td><input class="text" name='place' style="width:154px"
					value=""  readOnly/></td>
			</tr>
			<tr>
				<td>单位:</td>
				<td><input class="text" name='unit' style="width:154px"
					value=""  readOnly/></td>
			</tr>
			<tr>
				<td>规格:</td>
				<td><input class="text" name='standard' style="width:154px"
					value="" readOnly /></td>
			</tr>
			<tr>
				<td>包装:</td>
				<td><input class="text" name='packing' style="width:154px"
					value=""  readOnly/></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input class="text" name='price' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>库存个数:</td>
				<td><input class="text" name='number' style="width:154px"
					value=""  readOnly/></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="50px">
				<a href="javascript:void(0);" class="easyui-linkbutton" id="btnUpdPrice" data-options="iconCls:'icon-ok'">修改价格</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0);" class="easyui-linkbutton" id="btnCancel" data-options="iconCls:'icon-cancel'">取消</a>
				
				</td>
			</tr>

		</table>
	</form>

</body>

</html>