<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.0.min.js"></script>
<style type="text/css">
.fform {
	margin: 0;
	padding: 10px 10px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 100px;
	text-align: right;
}

.fitem input {
	width: 350px;
}

.fitem textarea {
	width: 350px;
	height: 60px;
}
</style>
</head>
<body>
<div align="center">
	<form id="formBizBodCall" method="post" class="fform" action="" style="width:600px;text-align: left">
		<fieldset>
			<legend>WebService地址</legend>
			<div class='fitem'>
				<label>url:</label>
				<input id="ws-url" name='url' type='text' value='http://demo2.ort.com.cn:9080/axis/services/BizBod'/>
			</div>
		</fieldset>
		<fieldset>
			<legend>调用参数</legend>
			<div class='fitem'>
				<label>transId:</label>
				<input name='transId' type='text' />
			</div>
			<div class='fitem'>
				<label>opertype:</label>
				<select name="opertype">
					<option value="Start">Start</option>
					<option value="Stop">Stop</option>
				</select>
			</div>
			<div class='fitem'>
				<label>userIp:</label>
				<input type="text" name="userIp">
			</div>
			<div class='fitem'>
				<label>spCode:</label>
				<input type="text" name="spCode">
			</div>
			<div class='fitem'>
				<label>appName:</label>
				<input type="text" name="appName">
			</div>
			<div align="center">
				<input id="btn-submit" type="button" value="调用">
				<input type="reset" value="重置">
			</div>
		</fieldset>
	</form>
	<div style="width:600px;" align="left">
		<fieldset>
			<legend>调用结果</legend>
			<p id="result"></p>
		</fieldset>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$('#btn-submit').click(function(){
		$('#result').html('');
		if(!$('#ws-url').val()){
			alert('WebService url不能为空');
			return;
		}
		$.post('${pageContext.request.contextPath}/client/bizBod/call',$('#formBizBodCall').serialize(),function(result){
			if(result.success){
				var html = 'result:'+result.data.result+'<br>errorDetail:'+result.data.errorDetail;
				$('#result').html(html);
			}
		},'json');
	});
});
</script>
</body>
</html>