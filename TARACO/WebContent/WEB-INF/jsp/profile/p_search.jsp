<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
</head>
<body>
<h1>プロフィール検索</h1>
<form method="POST" action="/TARACO/PSearchSerlet">

<nav>
	<ul>
		<li>講師</li>
		<li>運営</li>
		<li>Aクラス</li>
		<li>Bクラス</li>
		<li>Cクラス</li>
		<li>Dクラス</li>
		<li>Eクラス</li>
	</ul>
</nav>

<table>
	<tr>
		<th>名前</th>
		<td><input type="text" name="NAME"></td>
	</tr>
	<tr>
		<th>会社名</th>
		<td><input type="text" name="POSITION"></td>
	</tr>
</table>

<input type="submit" name="P_REGIST" value="検索"><br>

</form>

</body>
</html>