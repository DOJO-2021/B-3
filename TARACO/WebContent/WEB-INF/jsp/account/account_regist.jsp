<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/TARACO/WebContent/css/account_login.css">
</head>
<body>
	<header>
		TARACO
		<script src="clock.js"></script>
	</header>
	<h1>新規登録</h1>

	<form method="POST" action="/simpleBC/RegistServlet">
		<table class="regist_table">
			<tr>
				<th>氏名</th>
			</tr>
			<tr>
				<td><input type="text" name="USER_NAME"></td>
			</tr>
			<tr>
				<th>会社名or講師/事務局</th>
			</tr>
			<tr>
				<td><input type="text" name="USER_POSITION"></td>
			</tr>
			<tr>
				<th>ID※8～16文字の英数字</th>
			</tr>
			<tr>
				<td><input type="text" name="USER_ID"></td>
			</tr>
			<tr>
				<th>PW※8～16文字の英数字</th>
			</tr>
			<tr>
				<td><input type="text" name="USER_PW"></td>
			</tr>
			<tr>
				<th>PW確認(上記と同じ内容を入力してください)</th>
			</tr>
			<tr>
				<td><input type="text" name="USER_PW"></td>

			</tr>
		</table>

		<div class="btn1">
			<input type="submit" name="REGIST" value="登録">
		</div>
	</form>
	<footer>
		<p id="copyright">&copy;©Copyright Beach Sandals All right
			reserved.</p>
	</footer>

</body>
</html>