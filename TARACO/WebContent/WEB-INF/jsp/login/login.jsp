<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
</head>
<body>
	<h2>TARACOへようこそ！</h2>
	<h4>
		TARACOは受講者・講師・運営のコミュニケーションをサポートするWebアプリケーションです。<br>
		卵の集合体であるタラコのように、受講生の皆さんはエンジニアの卵の集合体です。<br>
		DOJOを通して卵から稚魚へと成長し、IT業界という大海原へバラバラに巣立っていくその日まで、このTARACOをご利用ください。
	</h4>


	<form class="form" action="LoginServlet" method="post" id="form">
		<table class="login_form">
			<tr>
				<th>ID</th>
				<td><input type="text" name="USER_ID"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="USER_PW"></td>
			</tr>
		</table>
		<!-- ボタン -->
		<div class="login_button">
			<input type="submit" name="LOGIN" value="ログイン">
		</div>
	</form>
	<a href="AccountRegistServlet">新規登録</a>

</body>
</html>