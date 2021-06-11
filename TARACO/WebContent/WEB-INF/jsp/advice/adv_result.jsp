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
<h1>アドバイス検索結果</h1>

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


<c:forEach var="e" items="${cardList}" >
	<br>
	<table>
	<tr>
		<th>項目:</th><td><input type="text"size="5" name="adv_course" value="${e.adv_course}"></td>
		<th>受講年度:</th><td><input type="text" name="adv_year" value="${e.adv_year}"></td>
	</tr>
	<tr>
		<th>アドバイス本文</th><td><input type="text" name="adv_content" value="${e.adv_content}"></td>
	</tr>
	</table>
</c:forEach>


</body>
</html>