<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>

<link rel="stylesheet" href="/TARACO/css/advice.css">
<link rel="stylesheet" href="/TARACO/css/common.css">

</head>
<body>
<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
<h1>運営PW変更</h1>

<a href="/TARACO/ADVRegistServlet">新規登録</a>
<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a><br><br>


<form method="POST" action="/TARACO/ADVPWServlet" id="form">
<table>
	<tr>
		<th>新しいPW<span class="small">※8～16文字の英数字</span></th><td><input type="text" name="adv_pw"></td>
	</tr>
	<tr>
		<th>確認用PW<span class="small">(上記と同じPWを入力してください)</span></th><td><input type="text" name="pw_confirm"></td>
	</tr>
	</table>
		<p id="errormsg"></p>
<input type="submit" name="REGIST" value="変更"><br>
</form>
<br><br>
<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
<script type="text/javascript" src="/TARACO/js/adv_regist_pw.js"></script>
</body>
</html>