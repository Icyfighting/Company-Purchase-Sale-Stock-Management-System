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
			url : 'stock?method=selStock',
			columns : [ [ {
				field : 'id',
				title : '库存编号',
				width : 100
			}, {
				field : 'sname',
				title : '商品简称',
				width : 100
			}, {
				field : 'productName',
				title : '商品名称',
				width : 100
			}, {
				field : 'place',
				title : '产地',
				width : 100
			}, {
				field : 'standard',
				title : '规格',
				width : 100
			}, {
				field : 'packing',
				title : '包装',
				width : 100
			}, {
				field : 'unit',
				title : '单位',
				width : 100
			}, {
				field : 'price',
				title : '单价',
				width : 100
			}, {
				field : 'number',
				title : '库存数量',
				width : 100
			} ] ],
			pagination : true,
			title : "库存列表",
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
				"column" :$("#comboSrch1").combobox("getValue"),//不能简单的使用$().val(),必须用这个...
				"operator" : $("#comboSrch2").combobox("getValue"),
				"srchVal" : $("#srchValue").val()
			});
		});
		
		$("#comboSrch1").combobox({ editable: false}); 
		$("#comboSrch2").combobox({ editable: false}); 




	});
</script>

</head>

<body>
	<table id="dg"></table>

	<div id="tb" style="padding:3px">
		<select id="comboSrch1" name="comboSrch1" class="easyui-combobox" style="width:100px" >
			<option value="1" >库存编号</option>
			<option value="2">商品名称</option>
			<option value="4">库存数量</option>
		</select>
		<select id="comboSrch2" name="comboSrch2" class="easyui-combobox" style="width:50px" >
			<option value="1">大于</option>
			<option value="2">等于</option>
			<option value="3">小于</option>
		</select> 
		<input id="srchValue" style="line-height:26px;border:1px solid #ccc"> 
		<a id="btnSrch" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">查询</a>
		
	</div>
</body>
</html>
