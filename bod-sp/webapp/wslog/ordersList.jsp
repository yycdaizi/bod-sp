<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日志</title>
<jsp:include page="/include.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<table id="gridList" class="easyui-datagrid"
			data-options="
			fit: true,
			autoRowHeight: false, 
			singleSelect: true, 
			url:'${pageContext.request.contextPath}/wslog/orders/page',
			pagination: true,
			rownumbers: true,
			fitColumns: true,
			sortName:'processTime',
			sortOrder:'desc'
			">
			<thead>
				<tr>
					<th data-options="field:'transId',sortable:true,width:100">交易ID</th>
					<th data-options="field:'acceptTime',sortable:true,width:100">受理时间</th>
					<th data-options="field:'orderType',width:200,formatter:function(v,row){return '网络加速'}">交易类型</th>
					<th data-options="field:'userIP',width:200">用户IP</th>
					<th data-options="field:'spId',width:100">SPID</th>
					<th data-options="field:'originIP',width:80">来源</th>
					<th data-options="field:'content',width:150">内容</th>
					<th data-options="field:'orderStatus',width:80">处理状态</th>
					<th data-options="field:'processTime',width:150">处理时间</th>
					<th data-options="field:'reason',width:100">原因</th>
				</tr>
			</thead>
		</table>
	</div>
	<script type="text/javascript">
	function operateFormatter(value, row, index){
		var html = [];
		html.push(app.operateButton('icon-edit','修改','showEditDialog('+index+')'));
		html.push(app.operateSplit);
		html.push(app.operateButton('icon-wrench','分配角色','showRoleAssignDialog('+index+')'));
		html.push(app.operateSplit);
		html.push(app.operateButton('icon-cancel','删除','doDelete('+index+')'));
		return html.join('');
	}
	
	$(function(){
		$('#btnQuery').click(function(){
			var params = $('#formQuery').serializeObject();
			var oldParms = $('#gridList').datagrid('options').queryParams;
			$('#gridList').datagrid('load',$.extend(oldParms, params));
		});
		
		$('#btnClearQuery').click(function(){
			$('#formQuery').form('clear');
		});
	});
	</script>
</body>
</html>