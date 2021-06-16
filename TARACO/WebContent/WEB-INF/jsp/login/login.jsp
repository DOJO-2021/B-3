<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/login_account.css">
</head>
<body class="login_body">

	<div class="introduction">
		<h2>TARACOへようこそ！</h2>
		<p id="sub">
			 &emsp;TARACOは受講者・講師・運営のコミュニケーションをサポートするWebアプリケーションです。<br>
			 &emsp;卵の集合体であるタラコのように、受講生の皆さんはエンジニアの卵の集まりです。
			DOJOを通して卵から稚魚へと成長し、IT業界という大海原へバラバラに巣立っていくその日まで、このTARACOをご利用ください。
		</p>
	</div>

	<div class="login_box">
		<form class="login_form" action="LoginServlet" method="post" id="form">
			<table class="login_table">
				<tr>
					<th><img src="images/login_icon.png" alt="ID"></th>
					<td><input type="text" name="USER_ID" placeholder="User_id" class="login"></td>
				</tr>
				<tr>
					<th><img src="images/pw_icon.png" alt="PW" ></th>
					<td><input type="password" name="USER_PW"
						placeholder="password" class="login"></td>
				</tr>
			</table>
			<!-- エラーメッセージ -->
			<p id="errormsg"></p>
			<!-- ボタン -->
			<input type="submit" name="LOGIN" value="Log in" class="login_botton">
		</form>
		 <a href="AccountRegistServlet" class="btn1"> 新規登録はこちら→ </a>
	</div>
	<script src="/TARACO/js/login.js"></script>
</body>
</html>