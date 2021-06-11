<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/login_account.css">
<script type="text/javascript" src="/TARACO/js/login.js"></script>
</head>
<body class="login_body">
	<div class="introduction">
		<h2>TARACOへようこそ！</h2>
		<p id="sub">
			TARACOは受講者・講師・運営のコミュニケーションをサポートするWebアプリケーションです。<br>
			卵の集合体であるタラコのように、受講生の皆さんはエンジニアの卵の集合体です。
			DOJOを通して卵から稚魚へと成長し、IT業界という大海原へバラバラに巣立っていくその日まで、このTARACOをご利用ください。
		</p>
	</div>

	<div class="login_box">
		<form class="login_form" action="LoginServlet" method="post" id="form">
			<table class="login_table">
				<tr>
					<th>ID</th>
					<td><input type="text" name="USER_ID"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="USER_PW"></td>
				</tr>
			</table>
			<p id="errormsg"></p>
			<!-- ボタン -->
			<input type="submit" name="LOGIN" value="ログイン">
		</form>
		<br>
		<a href="AccountRegistServlet" class="btn1">  <button type="button">新規登録</button></a>
	</div>
</body>
</html>