<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="themes/default/easyui.css" />
<link rel="stylesheet" href="themes/icon.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : 'instorage1?method=selInStorage',
			columns : [ [ {
				field : 'id',
				title : '入库编号',
				width : 100
			}, {
				field : 'supplierName',
				title : '供应商名称',
				width : 100
			}, {
				field : 'idate',
				title : '入库时间',
				width : 100
			}, {
				field : 'operator',
				title : '操作人员',
				width : 100
			},{
				field : 'brokerage',
				title : '经手人',
				width : 100
			}, {
				field : 'settlement',
				title : '结算方式',
				width : 100
			},{
				field : 'productName',
				title : '商品名称',
				width : 100
			}, {
				field : 'price',
				title : '单价',
				width : 100
			} , {
				field : 'number',
				title : '数量',
				width : 100
			} , {
				field : 'actualPay',
				title : '实付',
				width : 100
			} ] ],
			pagination : true,
			title : "入库记录表",
			toolbar : "#tb",
			fit : true,
			fitColumns : true,
			singleSelect : true,
			pageSize : 5,
			pageList : [ 5, 10, 15, 20 ],
			striped : true,
			rownumbers : true
		});

		// 给修改按钮绑定事件
		$("#btnUpd").click(function() {
			var selected = $("#dg").datagrid("getSelected");
			if (selected == null) {
				$.messager.alert("警告", "请先选中后修改!", "warning");
			} else {
				$("#dlgUpd").dialog({
					width : "350",
					height : "400",
					title : "修改入库信息",
					buttons : "#dlgBtn",
					modal : true
				});
				$("#fm").form("load", selected);
			}
		});

		$("#btnNo").click(function() {
			$("#dlgUpd").dialog("close");
		});

		// 给修改按钮绑定事件
		$("#btnOk").click(function() {
			$("#fm").form('submit', {
				url : "",
				success : function(data) {
					var msg = "";
					if (data == "true") {
						msg = "修改成功!";
						$("#fm").form("clear");
						$("#dlgUpd").dialog("close");
						$("#dg").datagrid("reload");
					} else {
						msg = "修改失败!";
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
	});
</script>
</head>

<body>
	<table id="dg"></table>
	<!-- <div id="tb">
		<a id="btnUpd" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
		<a id="btnDel" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
	</div> -->
<!-- 	
	<div id="dlgUpd">
		<center>
			<form id="fm" action="user" method="post" style="margin-top:30px;">
				<input type="hidden" name="method" value="updUser" />
				<table>
					<tr>
						<td>入库编号:</td>
						<td><input type="text" name="id" readonly /></td>
					</tr>
					<tr>
						<td>供应商名称:</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>入库时间:</td>
						<td><input type="text" name="udate" class="easyui-datebox" data-options="editable:false" /></td>
					</tr>
					<tr>
						<td>操作人员:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>经手人:</td>
						<td><input type="text" name="phone" /></td>
					</tr>
					<tr>
						<td>结算方式:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>商品编号:</td>
						<td><input type="text" name="phone" /></td>
					</tr>
					<tr>
						<td>单价:</td>
						<td><input type="text" name="phone" /></td>
					</tr>
					<tr>
						<td>数量:</td>
						<td><input type="text" name="phone" /></td>
					</tr>
					<tr>
						<td>实付:</td>
						<td><input type="text" name="phone" /></td>
					</tr>
				</table>
			</form>
		</center>
	</div> -->
	<!-- 对话框中的按钮 -->
	
<!-- 	 <div id="dlgBtn">
		<a id="btnOk" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a>
		<a id="btnNo" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
	</div>  -->
</body>
</html>
