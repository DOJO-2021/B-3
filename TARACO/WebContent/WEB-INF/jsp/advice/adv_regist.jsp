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
<h1>アドバイス登録</h1>

<a href="/TARACO/ADVRegistServlet">新規登録</a>
<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a>

<input type="submit" name="REGIST" class="edit_login_button" value="PW変更はこちらから"><br><br>

<form method="POST" action="/TARACO/ADVRegistServlet">
<table>
	<tr>
		<th>項目:</th><td><input type="text" name="adv_course" value="${e.adv_course}"></td>
		<th>受講年度:</th><td><input type="text" name="adv_year" value="${e.adv_year}"></td>
	</tr>
	<tr>
		<th colspan="2">アドバイス本文<span class="small">※400字以内</span></th>
	</tr>
	<tr>
		<td colspan="4">
		<textarea name="adv_content" cols="65" rows="6">${e.adv_content}</textarea>
		</td>
	</tr>
	</table>

<input type="submit" name="REGIST" value="新規登録"><br>
</form>

<br>
<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>