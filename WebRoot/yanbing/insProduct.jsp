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
<link rel="stylesheet" rev="stylesheet" href="css/style.css"
	type="text/css" media="all" />

<style type="text/css">
table {
	margin-left: 200px;
	margin-top: 100px;
	width: 50%;
	border-collapse: collapse;
}

td {
	border: 1px solid gray;
}
</style>
<script type="text/javascript">
	$(function() {

		//供应商下拉列表
		$("#supplierId").combobox({
			url : 'product?method=selAllSupplier',
			valueField : 'id',
			textField : 'name',
			editable : false
		});

		$("#btnSave").click(function() {
			// 转换为ajax提交
			$("form").form({
				"url" : "product?method=insProduct",
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
		$("#btnCancel").click(function() {
			$("#form").form("clear");

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

	<form id="form" method="post">
		<table id="table">
			<caption
				style="background-color: #6795B4; height: 30px; line-height: 30px; color: white; border: 1px solid gray; border-bottom: none;">添加商品信息</caption>

			<!-- 	<input type="hidden" name="method" value="insProduct" /> -->
			<tr>
				<td>产品名称：</td>
				<td><input name="name" type="text" class="text"
					style="width:154px" value="" /></td>
			</tr>
			<tr>
				<td>产品简称:</td>
				<td><input class="text" type="text" name="sname"
					style="width:154px" value="" /></td>
			</tr>
			<tr>
				<td>供应商编号:</td>
				<td><input id="supplierId" name="supplierId"
					style="width:158px;" value="" /></td>
			</tr>
			<tr>
				<td>产地:</td>
				<td><input class="text" name='place' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>单位:</td>
				<td><input class="text" name='unit' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>规格:</td>
				<td><input class="text" name='standard' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>包装:</td>
				<td><input class="text" name='packing' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>批号:</td>
				<td><input class="text" name='batchno' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>批准文号:</td>
				<td><input class="text" name='approval' style="width:154px"
					value="" /></td>
			</tr>
			<tr>
				<td>备注:</td>
				<td colspan="3"><textarea name="remark" cols="50" rows="8"
						style="resize: none;"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="50px"><a
					href="javascript:void(0);" class="easyui-linkbutton" id="btnSave"
					data-options="iconCls:'icon-ok'">提交</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="javascript:void(0);" class="easyui-linkbutton" id="btnCancel"
					data-options="iconCls:'icon-cancel'">取消</a></td>
			</tr>

		</table>
	</form>

</body>

</html>