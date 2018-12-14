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
			url : 'product?method=productList',
			columns : [ [ {
				field : 'id',
				title : '商品编号',
				width : 100
			}, {
				field : 'name',
				title : '商品名称',
				width : 100
			}, {
				field : 'sname',
				title : '商品简称',
				width : 100
			}, {
				field : 'place',
				title : '产地',
				width : 100
			}, {
				field : 'supplierName',
				title : '供应商名称',
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
				field : 'batchno',
				title : '批号',
				width : 100
			}, {
				field : 'approval',
				title : '批准文号',
				width : 100
			}, {
				field : 'remark',
				title : '备注',
				width : 100
			}] ],
			pagination : true,
			title : "商品列表",
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
		
		//增加删除商品功能
		$("#btnDel").click(function() {
			var selected = $("#dg").datagrid("getSelected");
			if(selected == null) {
				$.messager.alert("警告", "请选中后再进行删除!", "warning");
			} else {
				$.messager.confirm("询问", "确认要删除[" + selected.name + "]吗?", function(r) {
					if(r) {
						//根据商品编号删除对应商品在t_product中数据
						$.get("product", {"method":"delProduct", "id":selected.id}, function(data) {
							var msg = "";
							if(data == "true") {
								msg = "删除成功!";
								// 刷新当前页
								$("#dg").datagrid("reload");
							} else {
								msg = "删除失败!";
							}
							$.messager.show({
								"title" : "系统消息",
								"msg" : msg,
								"timeout" : 2000,
								"showType" : "slide"
							});
						});
					}
				});
			}
		});

		$("#comboSrch1").combobox({ editable: false}); 
		$("#comboSrch2").combobox({ editable: false}); 


	});
</script>

</head>

<body>
	<table id="dg"></table>

	<div id="tb" style="padding:3px">
		<select id="comboSrch1" name="comboSrch1" class="easyui-combobox" style="width:100px">
			<option value="1">商品编号</option>
			<option value="2">商品名称</option>
			<option value="3">公司名称</option>
		</select>
		<select id="comboSrch2" name="comboSrch2" class="easyui-combobox" style="width:50px">
			<option value="1">大于</option>
			<option value="2">等于</option>
			<option value="3">小于</option>
		</select> 
		<input id="srchValue" style="line-height:26px;border:1px solid #ccc"> 
		<a id="btnSrch" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'">查询商品</a>-
		<a id="btnDel" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove'">删除商品</a>
	</div>
</body>
</html>
