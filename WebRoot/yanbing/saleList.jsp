<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="themes/default/easyui.css" />
<link rel="stylesheet" href="themes/icon.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : 'sale?method=saleList',
			columns : [ [ {
				field : 'id',
				title : '销售记录编号',
				width : 100
			}, {
				field : 'clientName',
				title : '客户名称',
				width : 100
			}, {
				field : 'sdate',
				title : '销售日期',
				width : 100
			}, {
				field : 'productName',
				title : '产品名称',
				width : 100
			}, {
				field : 'price',
				title : '销售价格',
				width : 100
			}, {
				field : 'number',
				title : '销售数量',
				width : 100
			}, {
				field : 'actualIncome',
				title : '实收',
				width : 100
			}, {
				field : 'settlement',
				title : '支付方式',
				width : 100
			}, {
				field : 'operator',
				title : '操作员',
				width : 100
			}, {
				field : 'brokerage',
				title : '经手人',
				width : 100
			} ] ],
			pagination : true,
			title : "销售信息列表",
			toolbar : "#tb",
			fit : true,
			fitColumns : true,
			singleSelect : true,
			pageSize : 5,
			pageList : [ 5, 10, 15, 20 ],
			striped : true,
			rownumbers : true
		});

		$("#btnSrch").click(function() {
			$("#dg").datagrid('reload', {
				"column" : $("#comboSrch1").combobox("getValue"),//不能简单的使用$().val(),必须用这个...
				"operator" : $("#comboSrch2").combobox("getValue"),
				"srchVal" : $("#srchValue").val(),
				"startDate" : $("#startDate").datebox("getValue"),
				"endDate" : $("#endDate").datebox("getValue")
			});

		});



	});
</script>

</head>

<body>
	<table id="dg"></table>

	<div id="tb" style="padding:3px">
		<select id="comboSrch1" name="comboSrch1" class="easyui-combobox"
			style="width:100px">
			<option value="1">销售记录编号</option>
			<option value="2">商品名称</option>
			<option value="3">客户名称</option>
		</select> <select id="comboSrch2" name="comboSrch2" class="easyui-combobox"
			style="width:50px">
			<option value="1">大于</option>
			<option value="2">等于</option>
			<option value="3">小于</option>
		</select> <input id="srchValue" style="line-height:26px;border:1px solid #ccc">
		<span>查询日期：</span> <input
			type="text" id="startDate" name="startDate" class="easyui-datebox"
			data-options="editable:false" style="width:158px" />至 <input
			type="text" id="endDate" name="endDate" class="easyui-datebox"
			data-options="editable:false" style="width:158px" />
			<a id="btnSrch" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">查询销售记录</a>
	</div>
</body>
</html>
