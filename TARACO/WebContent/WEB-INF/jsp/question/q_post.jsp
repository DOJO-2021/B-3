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
<form id="post" method="post" action="/TARACO/QPostServlet" >
<table class="post_table">
	<tr><th>投稿者:</th>
	<td class ="post_table_td"><input class="post_text" type="text" name="Q_USER"placeholder="匿名希望の方は「匿名希望」と入力してください。" required></td></tr>
	<tr><th>質問内容:</th><td class="small">※400字以内</td></tr>
</table>
	<textarea class="questionSentences" name="QUESTION" required></textarea>
<table class="post_table">
	<tr><th>Aボタンの回答</th><td><input class="post_text" type="text" name="A_ANSWER" required></td></tr>
	<tr><th>Bボタンの回答</th><td><input class="post_text" type="text" name="B_ANSWER" required></td></tr>
	<tr><th>削除用パスワード</th><td><input class="post_text"  id="q_delete"type="password" name="QUESTION_PASS" placeholder="英数半角数字で4桁"  required></td></tr>
	<tr class="smallerror"><th></th><td><p id="errormsg"></p></td></tr>
</table>
<input type="submit" id="post_question"name="QUESTION_POST"value="アンケート投稿">
</form>
<script src="/TARACO/js/q_post.js"></script>
<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>