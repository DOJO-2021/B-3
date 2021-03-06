<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 実験用 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/advice.css">
<link rel="stylesheet" href="/TARACO/css/common.css">
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>

<script>
	var pass = "${pwscope.adv_pw}";
</script>

<body>
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>

	<h1>アドバイス検索</h1>

	<div class="pw">
		<form method="GET" action="/TARACO/ADVRegistServlet">
			<button type="submit" name="REGIST" value="code" class="login_button"
				id="click">
				登録編集はこちら<br>(運営専用)
			</button>
		</form>
	</div>
	<p class="advice">昨年度までの受講生が、修了報告書の<strong>「後輩へのアドバイス」</strong>欄で
	<br>記入した内容を検索・閲覧することができます。
	<br>DOJO事務局の方は、掲載する内容の登録・更新・削除が可能です。</p>

	<form method="POST" action="/TARACO/AdviceSearchServlet">
		<table class="a_search">
			<tr>
				<th>フリーワード</th>
				<td><input type="text" name="adv_content"></td>
			</tr>
			<tr>
				<th>受講コース</th>
				<td><select name="adv_course">
						<option value="" hidden>コースを選択してください</option>
						<option value="パーソナルスキルコース">パーソナルスキルコース</option>
						<option value="IT基礎">IT基礎</option>
						<option value="Java基礎">Java基礎</option>
						<option value="開発演習">開発演習</option>
				</select></td>


			</tr>
		</table>
		<input type="submit" name="REGIST" value="検索" class="submit"><br>
	</form>
	<br>
	<br>
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
	<script src="/TARACO/js/adv_pw.js"></script>
</body>
</html>