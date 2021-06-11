<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>

<link rel="stylesheet" href="/TARACO/css/advice.css">
<%-- ヘッダーフッター適用する
<link rel="stylesheet" href="/TARACO/css/style.css"> --%>

</head>
<body>

<h1>アドバイス検索</h1>

<form method="POST" action="/TARACO/AdviceSearchServlet" >
<button type="submit" name="REGIST" value="code"  class="login_button">登録編集はこちら<br>(運営専用)</button>
</form>

<form method="POST" action="/TARACO/AdviceSearchServlet">
<table>
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


</body>
</html>