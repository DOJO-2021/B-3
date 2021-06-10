<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>

<link rel="stylesheet" href="/TARACO/css/advise.css">
<%-- ヘッダーフッター適用する
<link rel="stylesheet" href="/TARACO/css/style.css"> --%>

</head>

<body>
<div class="wrapper">
<h1 class="midashi">アドバイス検索</h1>

<form method="POST" action="/TARACO/AdviceSearchServlet" align="center">
<table align="center">
<tr>
	<th>フリーワード</th><td><input type="text" name="adv_content"></td>
</tr>
<tr>
	<th>項目</th><td><input type="text" name="adv_course"></td>
</tr>
</table>
<br>
<input type="submit" name="REGIST" value="検索"><br>
</form>

</div>

</body>
</html>