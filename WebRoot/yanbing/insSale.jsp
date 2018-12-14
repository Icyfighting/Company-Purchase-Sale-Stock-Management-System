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
var selected;

	//展示库存列表
	$(function() {
		$('#dg').datagrid({
			url : 'stock?method=selStock',
			columns : [ [ {
				field : 'id',
				title : '库存编号',
				width : 100
			},{
				field : 'productId',
				title : '商品编号',
				width : 100
			},{
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


	//销售选中的商品功能
		$("#btnSale").click(
				function() {
					selected = $("#dg").datagrid("getSelected");
					if (selected == null) {
						$.messager.alert("警告", "请选中需要销售的一种商品!", "warning");
					} else {
						$("#saleInfo").dialog({
							width : "350",
							height : "480",
							title : "补充销售信息",
							buttons : "#dlgBtn",
							modal : true
						});
						$("#formShow").form("load",selected);
						$("#clientId").combobox({
							url : 'sale?method=selAllClient',//查新的数据ClientDao
							valueField : 'id',
							textField : 'sname',
							editable : false
						});
						$("#number").change(function(){
							var num=$("#number").val();
							
							if(num!=0){
								$("#actualIncome").val(num*$("#price").val());
							}else{
								$("#actualIncome").val(0.0);
							}
						});
					}
				});
		$("#btnOk").click(function(){
			$('#formAdd').form('submit', {    
			    url:"sale?method=addSale",    
			    onSubmit: function(param){   
			    	//额外提交的参数
			    	param.productId=selected.productId;//没有读取这个字段，要读一下
			    	param.price=selected.price;
			        // do some check    
			        // return false to prevent submit;  
			        return true;//之后增加提交前验证
			    },    
			    success:function(data){    
			        //alert(data);
			        var msg = "";
					if(data == "true") {
						msg = "销售成功!";
						// 刷新当前页
						$("#dg").datagrid("reload");
						$("#formAdd").form("reset");
					} else {
						msg = "销售失败!";
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
		$("#btnNo").click(function() {
			$("#formAdd").form("clear");

		});
		

	});
</script>
</head>


<body>
	<!-- 先展示库存数据，显示可以销售的内容和数量 -->
	<table id="dg"></table>
	<div id="tb" style="padding:3px">
		<a id="btnSale" href="javascript:void(0);" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit'">销售商品</a>
	</div>
	<!-- 选中后弹出的销售信息窗口 -->
	<div id="saleInfo">
		<center>
			<form id="formShow" method="post">
				<table id="table">
					<tr>
						<td>产品编号：</td>
						<td><input id="productId" name="productId"
							style="width:154px;" value="" readOnly /></td>
					</tr>
					<tr>
						<td>产品名称：</td>
						<td><input id="productName" name="productName"
							style="width:154px;" value="" readOnly /></td>
					</tr>
					<tr>
						<td>产品简称:</td>
						<td><input type="text" name="sname" style="width:154px"
							value=""  readOnly /></td>
					</tr>
					<tr>
						<td>产地:</td>
						<td><input type="text" name='place' style="width:154px"
							value="" readOnly /></td>
					</tr>
					<tr>
						<td>单位:</td>
						<td><input type="text" name='unit' style="width:154px"
							value=""readOnly  /></td>
					</tr>
					<tr>
						<td>规格:</td>
						<td><input type="text" name='standard' style="width:154px"
							value="" readOnly /></td>
					</tr>
					<tr>
						<td>包装:</td>
						<td><input type="text" name='packing' style="width:154px"
							value=""readOnly /></td>
					</tr>
					<tr>
						<td>统一售价:</td>
						<td><input id="price" type="text" name='price' style="width:154px"
							value="" readOnly /></td>
					</tr>
					<tr>
						<td>剩余库存:</td>
						<td><input type="text" name='number' style="width:154px"
							value="" readOnly /></td>
					</tr>
				</table>
			</form>
			
			<form id="formAdd" method="post">
				<table id="table">
					
					<input type="hidden" name="method" value="addSale" />
					<tr>
						<td>客户：</td><!-- 下拉列表显示客户选项 :完成-->
						<td><input id="clientId" name="clientId"
					style="width:158px;" value="" /></td>
					</tr>
					<tr>
						<td>销售日期:</td><!--日期插件  -->
						<td><input type="text" name="sdate" class="easyui-datebox" data-options="editable:false" style="width:158px" /></td>
					</tr>
					<tr>
						<td>操作员:</td><!--读取登录用户user.name  -->
						<td><input type="text" name='operator' style="width:154px"
							value="${sessionScope.user.rname}" /></td>
					</tr>
					<tr>
						<td>经手人:</td>
						<td><input type="text" name='brokerage' style="width:154px"
							value="" /></td>
					</tr>
					<tr>
						<td>结算方式:</td><!--固定的下拉列表选择  -->
						<td>
							<select id="settlement" name="settlement" class="easyui-combobox" style="width:158px">
								<option value=""></option>
								<option value="支票">支票</option>
								<option value="现金">现金</option>
								<option value="转账">转账</option>
							</select>
						
						</td>
					</tr>
					<tr>
						<td>出售数量:</td>
						<td><input id="number" type="text" name='number' style="width:154px"
							value="" /></td>
					</tr>
					<tr>
						<td>实收:</td>
						<td><input id="actualIncome" type="text" name='actualIncome' style="width:154px"
							value="" /></td>
					</tr>

				</table>
			</form>

		</center>
	</div>
	<div id="dlgBtn">
		<a id="btnOk" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确认销售</a>
		<a id="btnNo" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">放弃销售</a>
	</div>
</body>

</html>