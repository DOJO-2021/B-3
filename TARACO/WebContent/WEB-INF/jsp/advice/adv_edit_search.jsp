<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/advice.css">
<link rel="stylesheet" href="/TARACO/css/common.css">
</head>
<body>
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1>アドバイス編集</h1>
	<a href="/TARACO/ADVRegistServlet">新規登録</a>
	<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a><br><br>

	<form method="POST" action="/TARACO/ADVEditSearchServlet">
		<table>
			<tr>
				<th>フリーワード</th><td><input type="text" name="adv_content"></td>
			</tr>
			<tr>
				<th>項目</th><td>
				<select name="adv_course">
				<option value="" hidden>コースを選択してください</option>
				<option value="パーソナルスキルコース">パーソナルスキルコース</option>
				<option value="IT基礎">IT基礎</option>
				<option value="Java基礎">Java基礎</option>
				<option value="開発演習">開発演習</option>
				</select>
				</td>
			</tr>
		</table>
		<input type="submit" name="REGIST" value="検索"><br>
	</form>
	<br><br>

	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>