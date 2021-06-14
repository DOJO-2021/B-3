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
<h1>アドバイス検索結果</h1>

<form method="POST" action="/TARACO/AdviceSearchServlet">
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


<c:forEach var="e" items="${cardList}" >
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
</c:forEach>

<br>
<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>