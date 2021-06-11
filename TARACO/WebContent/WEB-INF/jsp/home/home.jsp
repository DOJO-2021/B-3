<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/common.css">
<script type="text/javascript" src="/TARACO/js/clock.js"></script>
</head>
<body>
	<!-- 独自のヘッダー -->
	<header>
		<img src="images/TARACO_icon.png" alt="TARACO" class="TARACO_icon">
		<h5 id="clock"></h5>
		<div class="mypage"><a href="MyPageServlet">マイページ</a></div>
	</header>
	<h1>ホーム</h1>

		<table id="summary_table">
			<tr>
				<td><a href="ProfileServlet"><img src="images/profile_icon.png" alt="プロフィール閲覧icon"></a></td>
				<td><a href="QustionServlet"><img src="images/question_icon.png" alt="アンケート掲示板icon"></a></td>
				<td><a href="AdviceServlet"><img src="images/advice_icon.png" alt="アドバイス閲覧icon"></a></td>
			</tr>
			<tr>
				<th>プロフィール閲覧</th>
				<th>アンケート掲示板</th>
				<th>アドバイス閲覧</th>
			</tr>
			<tr>
				<td>受講者・講師・事務局の人の<br>プロフィールが検索・閲覧できます。</td>
				<td>素朴な疑問をアンケート形式で<br>投稿・回答・閲覧できます。</td>
				<td>昨年までの受講者からの<br>アドバイスを検索・閲覧できます。</td>
			</tr>
		</table>



	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>

</body>
</html>