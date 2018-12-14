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
#table1 {
	width: 400px;
	border-collapse: collapse;
}

#table2 {
	width: 400px;
	border-collapse: collapse;
}

td {
	border: 1px solid gray;
}

#div1 {
	float: left;
	width: 420px;
}

#div2 {
	float: left;
	width: 420px;
}

#father {
	width: 900px;
	margin-left:100px;
	margin-top:100px;
}
</style>
<script type="text/javascript">
	$(function() {

		//商品下拉列表用全程
		$("#productId").combobox({
			url : 'product?method=selAllProduct',
			valueField : 'id',
			textField : 'name',
			editable : false
		});

		//给商品下拉列表绑定选中事件，展示选中商品的信息
		$("#productId").combobox({
			onSelect : function() {
				
			
				var value = $('#productId').combobox('getValue');
				//alert(value);
				$.get("product", {
					"method" : "selById",
					"id" : value
				}, function(data) {
					//alert(data[0].productName);
					$("#form2").form("load", data);
					$("#form1").get(0).reset();//清空，并显示下拉列表
					$('#productId').combobox('setValue',value);
				});

			}
		});
		
		$("#price").change(function(){
			var num=$("#number").val();
			var price=$("#price").val();
			$("#actualPay").val(num*price);
		});
		$("#number").change(function(){
			var num=$("#number").val();
			var price=$("#price").val();
			$("#actualPay").val(num*price);
		});

		$("#btnSave").click(function() {//提交两个表单内容才够，但是不能分别两个提交，否则判断结果不知道在哪个提交的success里提示结果，还是用onSubmit来提交额外参数
			//alert($("#name").val());
			// 转换为ajax提交
			$("#form1").form('submit', {
				"url" : "instorage?method=insInstorage",
				"onSubmit" : function(param) {
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
					param.name = $("#name").val();
					param.sname = $("#sname").val();
					param.place = $("#place").val();
					param.unit = $("#unit").val();
					param.standard = $("#standard").val();
					param.packing = $("#packing").val();
					param.supplierId = $("#supplierId").val();
					return true;
				},
				"success" : function(data) {
					var msg = "";
					if (data == "true") {
						msg = "入库成功!";
						// 刷新当前页
						$("#form1").get(0).reset();
					} else {
						msg = "入库失败!";
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

		});
	});

	function checkFields() {
		var t = $('#form1').serializeArray();//ajax中other方法，提供表单序列化
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

	<div id="father">
		<div id="div1">
			<form id="form1" method="post">
				<table id="table1">
					<caption
						style="background-color: #6795B4; height: 30px; line-height: 30px; color: white; border: 1px solid gray; border-bottom: none;">添加入库信息</caption>

					<!-- 	<input type="hidden" name="method" value="insProduct" /> -->
					<tr>
						<td>商品名称:</td>
						<td><input id="productId" name="productId"
							style="width:158px;" value="" /></td>
					</tr>
					<tr>
						<td>入库日期:</td>
						<td><input type="text" name="idate" class="easyui-datebox"
							data-options="editable:false" style="width:158px" /></td>
					</tr>
					<tr>
						<td>商品价格:</td>
						<td><input id="price" class="text" name='price' style="width:154px"
							value="" /></td>
					</tr>
					<tr>
						<td>入库数量:</td>
						<td><input id="number" class="text" name='number' style="width:154px"
							value="" /></td>
					</tr>
					<tr>
						<td>支付方式:</td>
						<td><select id="settlement" name="settlement"
							class="easyui-combobox" style="width:158px">
								<option value=""></option>
								<option value="支票">支票</option>
								<option value="现金">现金</option>
								<option value="转账">转账</option>
						</select></td>
					</tr>
					<tr>
						<td>实付:</td>
						<td><input id="actualPay" class="text" name='actualPay' style="width:154px"
							value="" /></td>
					</tr>
					<tr>
						<td>操作员:</td>
						<td><input type="text" name='operator' style="width:154px"
							value="${sessionScope.user.rname}" /></td>
					</tr>
					<tr>
						<td>经手人:</td>
						<td><input class="text" name='brokerage' style="width:154px"
							value="" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center" height="50px"><a
							href="javascript:void(0);" class="easyui-linkbutton" id="btnSave"
							data-options="iconCls:'icon-ok'">提交</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="javascript:void(0);" class="easyui-linkbutton"
							id="btnCancel" data-options="iconCls:'icon-cancel'">取消</a></td>
					</tr>

				</table>
			</form>
		</div>
		<div id="div2">
			<form id="form2" method="post">
				<table id="table2">
					<caption
						style="background-color: #6795B4; height: 30px; line-height: 30px; color: white; border: 1px solid gray; border-bottom: none;">商品信息展示</caption>
					<tr>
						<td>产品名称：</td>
						<td><input id="name" name="name" type="text" class="text"
							style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>产品简称:</td>
						<td><input id="sname" class="text" type="text" name="sname"
							style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>供应商名称:</td>
						<td><input id="supplierName" class="text" type="text"
							name="supplierName" style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>供应商编号:</td>
						<td><input id="supplierId" class="text" type="text"
							name="supplierId" style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>产地:</td>
						<td><input id="place" class="text" name='place'
							style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>单位:</td>
						<td><input id="unit" class="text" name='unit'
							style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>规格:</td>
						<td><input id="standard" class="text" name='standard'
							style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>包装:</td>
						<td><input id="packing" class="text" name='packing'
							style="width:154px" value="" readonly /></td>
					</tr>
					<tr>
						<td>批号:</td>
						<td><input class="text" name='batchno' style="width:154px"
							value="" readonly /></td>
					</tr>
					<tr>
						<td>批准文号:</td>
						<td><input class="text" name='approval' style="width:154px"
							value="" readonly /></td>
					</tr>
					<tr>
						<td>备注:</td>
						<td colspan="3"><textarea name="remark" cols="30" rows="5"
								style="resize: none;" readonly></textarea></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</body>

</html>