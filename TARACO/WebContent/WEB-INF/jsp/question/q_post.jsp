<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href="/TARACO/css/question.css">
</head>
<body>
<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
<h1>アンケート投稿フォーム</h1>
<form>
<div class="post_question">
<table class="post_table">
	<tr><th>投稿者:</th>
	<td><input type="text" name="Q_USER"placeholder="匿名希望の方は「匿名希望」と入力してください。"></td></tr>
	<tr><th>質問内容:</th><td class="small">※400字以内</td></tr>
</table>
	<input class="questionSentences"type="text" name=QUESTION>
<table class="post_table">
	<tr><th>Aボタンの回答</th><td><input type="text" name=A_ANSWER></td></tr>
	<tr><th>Bボタンの回答</th><td><input type="text" name=B_ANSWER></td></tr>
	<tr><th>削除用パスワード</th><td><input type="text" name=QUESTION_PASS></td></tr>

</table>
</div>
</form>
<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>