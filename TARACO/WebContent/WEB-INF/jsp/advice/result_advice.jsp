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

	<h1><c:out value="${result.title}" /></h1>

	<p><c:out value="${result.message}" /></p>

<a href="/TARACO/ADVRegistServlet">	アドバイス登録へ戻る</a><br>


</body>
</html>