<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>アドバイス編集</h1>

<a href="/TARACO/ADVRegistServlet">新規登録</a>
<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a><br><br>


<form method="POST" action="/TARACO/ADVEditSearchServlet">
<table>
<tr>
	<th>フリーワード</th><td><input type="text" name="adv_content"></td>
</tr>
<tr>
	<th>項目</th>
	<td>
	<select name="adv_course">
	<option value=""hidden>コースを選択してください</option>
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
<br>

検索結果:○○件

<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/TARACO/ADVEditResultServlet">
	<br>
	<table class="result_table">
	<tr>
		<th>項目:</th><td><input type="text" name="adv_course" value="${e.adv_course}"></td>
		<th>受講年度:</th><td><input type="text" name="adv_year" value="${e.adv_year}"></td>
	</tr>
	<tr>
		<th colspan="2">アドバイス本文</th>
	</tr>
	<tr>
		<td colspan="4">
		<textarea name="adv_content" cols="65" rows="6">${e.adv_content}</textarea>
		</td>
	</tr>
	</table>
<input type="submit" name="SUBMIT" value="更新">
<input type="submit" name="SUBMIT" value="削除" onclick="check()"><br>
	</form>
</c:forEach>

<br>
<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>

<script src="/TARACO/js/adv_delete.js"></script>

</body>
</html>