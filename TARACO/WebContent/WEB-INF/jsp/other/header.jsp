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
	<header>
		<a href="HomeServlet"><img src="images/TARACO_icon.png" alt="TARACO" class="TARACO_icon"></a>
		<h5 id="clock"></h5>
		<nav class="nav">
			<ul>
				<li><a href="HomeServlet"> ホーム</a> </li>
				<li><a href="PSearchServlet"> プロフィール</a></li>
				<li><a href="QuestionServlet"> アンケート</a></li>
				<li><a href="AdviceSearchServlet"> アドバイス</a></li>
				<li><a href="MyPageServlet">マイページ</a></li>
			</ul>
		</nav>
	</header>
<script src="/TARACO/js/clock.js"></script>
</body>
</html>