<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/login_account.css">
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>
<body>
	<!-- 独自のヘッダー -->
	<header>
		<img src="images/TARACO_icon.png" alt="TARACO" class="TARACO_icon">
		<h5 id="clock"></h5>
	</header>
	<h1>新規登録</h1>


	<form method="POST" action="/TARACO/AccountRegistServlet" id="form">
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
				<th>ID
					<div class="msg" style="display: inline-block; _display: inline;">※8～16文字の半角英数字</div>
				</th>
			</tr>
			<tr>
				<td><input type="text" name="USER_ID"></td>
			</tr>
			<tr>
				<th>PW
					<div class="msg" style="display: inline-block; _display: inline;">※8～16文字の半角英数字</div>
				</th>
			</tr>
			<tr>
				<td><input type="password" name="USER_PW"></td>
			</tr>
			<tr>
				<th>PW確認
					<div class="msg" style="display: inline-block; _display: inline;">※上記と同じ内容を入力してください</div>
				</th>
			</tr>
			<tr>
				<td><input type="password" name="PW_CONFIRM"></td>
			</tr>
		</table>
		<!-- エラーメッセージ -->
		<p id="errormsg"></p>
		<div class="regist_btn">
			<input type="submit" name="REGIST" value="登録">
		</div>
	</form>

	<!-- 独自のフッター -->
	<footer><p id="copyright">&copy;Copyright Beach Sandals. All right
		reserved.</p></footer>

	<script type="text/javascript" src="/TARACO/js/regist_account.js"></script>
	<script src="/TARACO/js/clock.js"></script>
</body>
</html>