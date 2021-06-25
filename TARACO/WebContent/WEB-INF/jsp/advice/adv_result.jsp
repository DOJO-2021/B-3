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
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>
<body>
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1>アドバイス検索結果</h1>

	<% String course=(String)(request.getAttribute("adv_course")); %>
	<form method="POST" action="/TARACO/AdviceSearchServlet">
		<table class="a_search2">
			<tr>
				<th>フリーワード</th><td><input type="text" name="adv_content"  value="${adv_content}"></td>
			</tr>
			<tr>
				<th>受講コース</th>
				<td>
				<select name="adv_course">
				<option value=""hidden>コースを選択してください</option>
				<option value="パーソナルスキルコース"  <%= "パーソナルスキルコース".equals(course)?" selected=\"selected\"":""%>>パーソナルスキルコース</option>
				<option value="IT基礎"  <%= "IT基礎".equals(course)?" selected=\"selected\"":""%>>IT基礎</option>
				<option value="Java基礎"  <%= "Java基礎".equals(course)?" selected=\"selected\"":""%>>Java基礎</option>
				<option value="開発演習"  <%= "開発演習".equals(course)?" selected=\"selected\"":""%>>開発演習</option>
				</select>
				</td>
			</tr>
		</table>
		<input type="submit" name="REGIST" value="検索" class="submit"><br>
	</form>
	<br>

	 <% int count = 0; %>
	<c:forEach var="e" items="${cardList}" >
	<% count++; %>
	</c:forEach>
	検索結果:<%=count %>件

	<c:forEach var="e" items="${cardList}" >
		<br>
		<table class="result_table">
		<tr>
			<th class="table1">受講コース:</th><td class="table2">${e.adv_course}</td>
			<th class="table3">受講年度:</th><td class="table4">${e.adv_year}年</td>
		</tr>
		<tr>
			<th colspan="2">アドバイス本文</th>
		</tr>
		<tr>
			<td colspan="4">${e.adv_content}</td>
		</tr>
		</table>
	</c:forEach>
	<br><br>

	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>