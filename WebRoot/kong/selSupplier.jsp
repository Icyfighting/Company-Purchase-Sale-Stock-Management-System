<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
		    url:"selSupplier?method=selSupplier",    
		    columns:[[
		        {field:'id',title:'供应商ID',width:100, align:'center'},    
		        {field:'name',title:'供应商名称',width:100, align:'center'},    
		        {field:'address',title:'地址',width:100, align:'center'},
		        {field:'sname',title:'简称',width:100, align:'center'},
		        {field:'zipcode',title:'邮政编码',width:100, align:'center'},
		        {field:'phone',title:'电　话',width:100, align:'center'},
		        {field:'fax',title:'传　真',width:100, align:'center'},
		        {field:'contact',title:'联 系 人',width:100, align:'center'},
		        {field:'contactPhone',title:'联系人电话',width:100, align:'center'},
		        {field:'email',title:'电子邮箱',width:100, align:'center'},
		        {field:'bank',title:'开户银行',width:100, align:'center'},
		        {field:'accountNumber',title:'银行账号',width:100, align:'center'}
		    ]],
		    pagination:true,
		    title: "供应商列表",
		    toolbar: "#tb",
		    fit: true,
		    fitColumns: true,
		    pageSize : 5,
			pageList : [ 5, 10, 15, 20 ],
		    striped: true,
		    rownumbers: true
		});
		$("#btnDel").click(function() {
			var cid = $("#slctCourse").val();
			var tid = $("#slctTeacher").val();
			if(cid != -1 && tid != -1) {
				$.messager.confirm("询问", "确定要删除吗?", function(r) {
					if(r){
						$.get("course", {"method":"delCourseTeacher", "cid":cid, "tid":tid}, function(data) {
							var msg = "";
							if (data == "true") {
								msg = "删除成功!";
								$("#dg").datagrid("reload");
							} else if(data == "false") {
								msg = "删除失败!";
							} else {
								msg = data;
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
	});
</script>
</head>

<body>
	<table id="dg"></table>
	<div id="tb">
	</div>
</body>
</html>
