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
<h1>運営PW変更</h1>

<a href="/TARACO/ADVRegistServlet">新規登録</a>
<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a><br><br>


<form method="POST" action="/TARACO/ADVPWServlet">
<table>
	<tr>
		<th>新しいPW※8～16文字の英数字</th><td><input type="text" name="adv_pw" value="${e.adv_pw}"></td>
	</tr>
	<tr>
		<th>確認用PW(上記と同じPWを入力してください)</th><td><input type="text" name="adv_pw" value="${e.adv_pw}"></td>
	</tr>
	</table>
<br>
<input type="submit" name="REGIST" value="変更"><br>
</form>


</body>
</html>