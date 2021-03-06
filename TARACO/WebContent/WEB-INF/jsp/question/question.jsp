<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/question.css">
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>
<body>
	<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1>アンケート掲示板</h1>
	<div class="gotoUpload">
		<a href="QPostServlet"><button class="submit">アンケート投稿はこちら</button></a>
	</div>
	<div class="caution">
		<p>※アンケートは投稿されてから24時間後に回答を締め切ります。</p>
	</div>
	<table class="questionFerris">
		<tr>
			<th>投稿日時:</th>
			<th>投稿者:</th>
			<th>質問内容:</th>
			<th>回答人数:</th>
		</tr>
		<c:forEach var="question" items="${billList}">
		<tr>
			<td>${question.q_date}</td>
			<td>${question.q_user}</td>
			<td><a href="QAnswerServlet?Q_ID=${question.q_id}">${question.q_content}</a></td>
			<td>${question.a_responses}</td>
		</tr>
		</c:forEach>
	</table>
	<p></p>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>