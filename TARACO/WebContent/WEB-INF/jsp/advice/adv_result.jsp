<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>

<link rel="stylesheet" href="/TARACO/css/advise.css">
<%-- ヘッダーフッター適用する
<link rel="stylesheet" href="/TARACO/css/style.css"> --%>

</head>

<body>
<div class="wrapper">
<h1 class="midashi">アドバイス検索結果</h1>

<form method="POST" action="/TARACO/AdviceSearchServlet" align="center">
<table align="center">
<tr>
	<th>フリーワード</th><td><input type="text" name="adv_content"></td>
</tr>
<tr>
	<th>項目</th><td><input type="text" name="adv_course"></td>
</tr>
</table>
<br>
<input type="submit" name="REGIST" value="検索"><br>
</form>

<c:forEach var="e" items="${cardList}" >
	<br>
	<table align="center">
	<tr>
		<th>名刺ID</th><td><input type="text"size="5" name="bc_id" value="${e.bc_id}"></td>
	</tr>
	<tr>
		<th>会社名</th><td><input type="text" name="comp_name" value="${e.comp_name}"></td>
		<th>部署名</th><td><input type="text" name="dept_name" value="${e.dept_name}"></td>
	</tr>
	<tr>
		<th>氏名</th><td><input type="text" name="name" value="${e.name}"></td>
		<th>読み仮名</th><td><input type="text" name="furigana" value="${e.furigana}"></td>
	</tr>
	<tr>
		<th>郵便番号</th><td><input type="text" name="zip_code" value="${e.zip_code}"></td>
		<th>住所</th><td><input type="text" name="address" value="${e.address}"></td>
	</tr>
	<tr>
		<th>TEL</th><td><input type="text" name="phone" value="${e.phone}"></td>
		<th>Fax</th><td><input type="text" name="fax" value="${e.fax}"></td>
	</tr>
	<tr>
		<th>Email</th><td><input type="text" name="email" value="${e.email}"></td>
		<th>登録日</th><td><input type="text" name="date" value="${e.date}"></td>
	</tr>
	<tr>
		<th>備考</th><td><input type="text"size="50" name="remarks" value="${e.remarks}"></td>
	</tr>
	</table>

</c:forEach>


</div>

</body>
</html>