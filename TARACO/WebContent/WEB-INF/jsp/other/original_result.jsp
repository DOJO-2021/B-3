<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/common.css">
</head>
<body>
	<!-- 独自のヘッダー -->
	<header>
		<img src="images/TARACO_icon.png" alt="TARACO" class="TARACO_icon">
		<h5 id="clock"></h5>
	</header>
	<!-- 処理結果文 -->
	<h1>
		<c:out value="${result.title}" />
	</h1>
	<p>
		<c:out value="${result.message}" />
	</p>
	<a href="${result.backTo}"><button type="button" class="backTo">戻る</button></a>

	<!-- 独自フッター -->
	<footer class="footer">
		<p class="copyright">&copy;Copyright Beach Sandals. All right
			reserved.</p>
	</footer>

	<script type="text/javascript" src="TARACO/js/clock.js"></script>
</body>
</html>