<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/profile.css">
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>
<body>
	<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1>プロフィール検索結果</h1>
	<form method="POST" action="/TARACO/PSearchServlet">

		<button type="submit" name="POSITION" value="講師">講師</button>
		<button type="submit" name="POSITION" value="事務局">事務局</button>
		<button type="submit" name="CLASS" value="A">Aクラス</button>
		<button type="submit" name="CLASS" value="B">Bクラス</button>
		<button type="submit" name="CLASS" value="C">Cクラス</button>
		<button type="submit" name="CLASS" value="D">Dクラス</button>
		<button type="submit" name="CLASS" value="E">Eクラス</button>


		<table class="p_search">
			<tr>
				<th>名前</th>
				<td><input type="text" name="NAME"></td>
			</tr>
			<tr>
				<th>会社名</th>
				<td><input type="text" name="POSITION"></td>
			</tr>
		</table>


		<input type="submit" name="P_SEARCH" value="検索" class="submit"><br>
	</form>

	<%
		int count = 0;
	%>

	<c:forEach var="e" items="${cardList}">
		<%
			count++;
		%>
	</c:forEach>
	<caption>
		検索結果<%=count%>件
	</caption>
	<div class="scroll">
		<table class="p_search_result">

			<tr>
				<th>クラス</th>
				<th>名前</th>
				<th>会社名</th>
			</tr>
			<!-- 拡張for文EL式 -->
			<c:forEach var="e" items="${cardList}">
				<tr>
					<td>${e.user_class}</td>
					<td><a href="PSearchResultServlet?PROFILE_ID=${e.profile_id}">${e.user_name}</a>
						<!-- <button type="submit" name="NAME">${e.user_name}</button>
				<input type="hidden" name="USER_ID" value="${e.user_id}"> --></td>

					<td>${e.user_position}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<br>
	<br>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
	<script src="/TARACO/js/mypage.js"></script>
</body>
</html>