<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<header><jsp:include page="/WEB-INF/jsp/other/header2.jsp" /></header>
	<h1>アドバイス編集</h1>
	<div class="nav2">
		<a href="/TARACO/ADVRegistServlet" class="to">新規登録</a> <a
			href="/TARACO/ADVEditSearchServlet" class="to">既存データの編集</a>
	</div>
	<%
		String course = (String) (request.getAttribute("adv_course"));
	%>

	<form method="POST" action="/TARACO/ADVEditSearchServlet">
		<table>
			<tr>
				<th>フリーワード</th>
				<td><input type="text" name="adv_content"
					value="${adv_content}"></td>
			</tr>
			<tr>
				<th>受講コース</th>
				<td><select name="adv_course">
						<option value="" hidden>コースを選択してください</option>
						<option value="パーソナルスキルコース"
							<%="パーソナルスキルコース".equals(course) ? " selected=\"selected\"" : ""%>>パーソナルスキルコース</option>
						<option value="IT基礎"
							<%="IT基礎".equals(course) ? " selected=\"selected\"" : ""%>>IT基礎</option>
						<option value="Java基礎"
							<%="Java基礎".equals(course) ? " selected=\"selected\"" : ""%>>Java基礎</option>
						<option value="開発演習"
							<%="開発演習".equals(course) ? " selected=\"selected\"" : ""%>>開発演習</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" name="REGIST" value="検索" class="submit"><br>
	</form>
	<br>

	<%
		int count = 0;
	%>
	<c:forEach var="e" items="${cardList}">
		<%
			count++;
		%>
	</c:forEach>
	検索結果:<%=count%>件

	<c:forEach var="e" items="${cardList}">
		<form method="POST" action="/TARACO/ADVEditResultServlet">
			<input type="hidden" name="adv_id" value="${e.adv_id}"> <br>
			<table class="result_table">
				<tr>
					<th>受講コース:</th>
					<td><input type="text" name="adv_course"
						value="${e.adv_course}"></td>
					<th>受講年度:</th>
					<td><input type="text" name="adv_year" value="${e.adv_year}"></td>
				</tr>
				<tr>
					<th colspan="2">アドバイス本文</th>
				</tr>
				<tr>
					<td colspan="4"><textarea name="adv_content" cols="65"
							rows="6" class="content">${e.adv_content}</textarea></td>
				</tr>
			</table>
			<input type="submit" name="SUBMIT" value="更新" class="submit">
			<input type="submit" name="SUBMIT" value="削除"
				onclick="return check()" class="submit"><br>
		</form>
	</c:forEach>
	<br>
	<br>
	<footer><jsp:include page="/WEB-INF/jsp/other/footer2.jsp" /></footer>
	<script src="/TARACO/js/adv_delete.js"></script>
</body>
</html>