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
	<h1 class="midashi"><c:out value="${result.title}" /></h1>

	<p><c:out value="${result.message}" /></p>

<a href="/TARACO/ADVRegistServlet">	アドバイス登録へ戻る</a><br>


</div>

</body>
</html>