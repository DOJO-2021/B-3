<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href = "/TARACO/css/profile.css">
</head>
<body>
<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
<h1>プロフィール検索</h1>
<form method="POST" action="/TARACO/PSearchServlet">


<button type="submit" name="POSITION" value="講師">講師</button>
<button type="submit" name="POSITION" value="運営">運営</button>
<button type="submit" name="CLASS" value="Aクラス">Aクラス</button>
<button type="submit" name="CLASS" value="Bクラス">Bクラス</button>
<button type="submit" name="CLASS" value="Cクラス">Cクラス</button>
<button type="submit" name="CLASS" value="Dクラス">Dクラス</button>
<button type="submit" name="CLASS" value="Eクラス">Eクラス</button>

</form>

<form method="POST" action="/TARACO/PSearchServlet">
<table>
	<tr>
		<th>名前</th>
		<td><input type="text" name="NAME"></td>
	</tr>
	<tr>
		<th>会社名</th>
		<td><input type="text" name="POSITION"></td>
	</tr>
</table>

<input type="submit" name="P_SEARCH" value="検索"><br>

</form>
<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>