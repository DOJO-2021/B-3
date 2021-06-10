<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
</head>
<body>
	<!-- 独自のヘッダー -->
	<header>
		TARACO
		<script src="clock.js"></script>
		<a href="MyPageServlet">マイページ</a>
	</header>
	<h1>ホーム</h1>
	<table>
		<tr>
			<td><img src="image/profile_icon.jpg" alt="プロフィール閲覧icon"></td>
			<td><img src="image/question_icon.jpg" alt="アンケート掲示板icon"></td>
			<td><img src="image/advice_icon.jpg" alt="アドバイス閲覧icon"></td>
		</tr>
		<tr>
			<th>プロフィール閲覧</th>
			<th>アンケート掲示板</th>
			<th>アドバイス閲覧</th>
		</tr>
		<tr>
			<td>受講者・講師・事務局の人のプロフィールが検索・閲覧できます。</td>
			<td>素朴な疑問をアンケート形式で投稿・回答・閲覧できます。</td>
			<td>昨年までの受講者からのアドバイスを検索・閲覧できます。</td>
		</tr>
	</table>


	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>

</body>
</html>