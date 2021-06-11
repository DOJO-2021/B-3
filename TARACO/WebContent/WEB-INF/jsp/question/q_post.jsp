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
<h1>アンケート投稿フォーム</h1>
<form>
<table>
	<tr><th class="columnA">投稿者:</th>
	<td><input type="text" name="Q_USER"placeholder="匿名希望の方は「匿名希望」と入力してください。"></td></tr>
	<tr><th class="columnA">質問内容:</th><td class="small">※400字以内</td></tr>
</table>
	<input class="questionSentences"type="text" name=QUESTION>
<table>
	<tr><th>Aボタンの回答</th><td><input type="text" name=A_ANSWER></td></tr>
	<tr><th>Bボタンの回答</th><td><input type="text" name=B_ANSWER></td></tr>

</table>
</form>
</body>
</html>