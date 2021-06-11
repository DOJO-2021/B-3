<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>

<link rel="stylesheet" href="/TARACO/css/advice.css">
<%-- ヘッダーフッター適用する
<link rel="stylesheet" href="/TARACO/css/style.css"> --%>

</head>
<body>
<h1>アドバイス登録</h1>

<a href="/TARACO/ADVRegistServlet">新規登録</a>
<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a><br><br>


<form method="POST" action="/TARACO/ADVRegistServlet">
<table>
	<tr>
		<th>項目:</th><td><input type="text"size="5" name="adv_course" value="${e.adv_course}"></td>
		<th>受講年度:</th><td><input type="text" name="adv_year" value="${e.adv_year}"></td>
	</tr>
	<tr>
		<th>アドバイス本文※400字以内</th><td><input type="text" name="adv_content" value="${e.adv_content}"></td>
	</tr>
	</table>
<br>
<input type="submit" name="REGIST" value="新規登録"><br>
</form>


</body>
</html>