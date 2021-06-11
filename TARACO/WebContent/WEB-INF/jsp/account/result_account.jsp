<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/common.css">
</head>
<body>
	<!-- 独自ヘッダー -->
	<header>
		TARACO
		<script src="clock.js"></script>
	</header>
	<!-- 処理結果文 -->
	<h1>
		新規登録失敗です！サーブレットから送る
		<!-- <c:out value="${result.title}" /> -->
	</h1>
	<p>
		<!--<c:out value="${result.message}" />-->
	</p>
	<a href="AccountRegistServlet"><button type="button">戻る</button></a>

	<!-- 独自フッター -->
	<footer class="footer">
		<p id="copyright">&copy;Copyright Beach Sandals All right
			reserved.</p>
	</footer>
</body>
</html>