<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/WebContent/css/common.css">
</head>
<body>
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<!-- 処理結果文 -->
	<h1>
		<!-- <c:out value="${result.title}" /> -->
	</h1>

	<p>
		<!--<c:out value="${result.message}" />-->
	</p>

	<footer class="footer">
		<jsp:include page="/WEB-INF/jsp/other/footer.jsp" />
	</footer>
</body>
</html>