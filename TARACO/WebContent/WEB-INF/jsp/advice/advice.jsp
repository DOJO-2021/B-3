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

<h1>アドバイス検索</h1>

<div class="pw">
<form method="GET" action="/TARACO/ADVRegistServlet" >
<button type="submit" name="REGIST" value="code"  class="login_button" id="click">登録編集はこちら<br>(運営専用)</button>
</form>
</div>

<br>
<form method="POST" action="/TARACO/AdviceSearchServlet">
<table>
<tr>
	<th>フリーワード</th><td><input type="text" name="adv_content"></td>
</tr>
<tr>
	<th>項目</th><td>
	<select name="adv_course">
	<option value="" hidden>コースを選択してください</option>
	<option value="all">all</option>
	<option value="personal">パーソナルスキルコース</option>
	<option value="IT">IT基礎</option>
	<option value="Java">Java基礎</option>
	<option value="development">開発演習</option>
	</select>
	</td>


</tr>
</table>
<input type="submit" name="REGIST" value="検索"><br>
</form>
<br><br>
<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
<script src="/TARACO/js/adv_pw.js"></script>
</body>
</html>