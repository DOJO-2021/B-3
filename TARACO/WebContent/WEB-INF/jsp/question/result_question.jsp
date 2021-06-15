<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/question.css">
</head>
<body>
<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1><c:out value="${result.title}" /></h1>
	<p>
		<c:out value="${result.message}" />
	</p>
	<p class="deadlineTimer" id="timer"></p>
	<table>
		<tr>
			<th>投稿者:</th>
			<td><input type="hidden" name="Q_USER" value=""></td>
		</tr>
		<tr>
			<th>質問内容:</th>
			<td><input type="hidden" name=QUESTION value=""></td>
		</tr>
	</table>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>