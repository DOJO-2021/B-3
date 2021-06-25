<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/advice.css">
<link rel="stylesheet" href="/TARACO/css/common.css">
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>
<body>
	<header><jsp:include page="/WEB-INF/jsp/other/header2.jsp" /></header>
	<h1>運営PW変更</h1>
	<div class="nav2">
		<a href="/TARACO/ADVRegistServlet" class="to">新規登録</a> <a
			href="/TARACO/ADVEditSearchServlet" class="to">既存データの編集</a>
	</div>

	<form method="POST" action="/TARACO/ADVPWServlet" id="form">
		<table class="edit_table">
			<tr>
				<th>新しいPW<span class="small">※8～16文字の英数字</span></th>
				<td><input type="text" name="adv_pw"></td>
			</tr>
			<tr>
				<th>確認用PW<span class="small">(上記と同じPWを入力してください)</span></th>
				<td><input type="text" name="pw_confirm"></td>
			</tr>
		</table>
		<p id="errormsg"></p>
		<input type="submit" name="REGIST" value="変更" class="submit"><br>
	</form>
	<br>
	<br>

	<footer><jsp:include page="/WEB-INF/jsp/other/footer2.jsp" /></footer>
	<script type="text/javascript" src="/TARACO/js/adv_regist_pw.js"></script>
</body>
</html>