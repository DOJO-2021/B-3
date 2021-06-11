<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<link rel="stylesheet" href="/TARACO/css/question.css">
</head>
<body>
<h1>回答/集計</h1>
<a class="deleteQuestion">削除</a>
<p class="deadlineTimer"id="timer"></p>
<form>
<table>
	<tr><th>投稿者:</th>
	<td>事務局<input type="hidden" name="Q_USER"value=""></td></tr>
	<tr><th>質問内容:</th>
	<td class="questionSentences">この質問について回答お願いします。<input type="hidden" name=QUESTION value=""></td></tr>
</table>
<table>
<tr><th>合計79人</th><th>Aの回答30人</th><th>Bの回答39人</th></tr>
</table>
<input type = "submit"name="POST_QUESTION" value="投稿">
</form>
<canvas id="resultGraph"></canvas>
<script src="/TARACO/js/q_answer.js"></script>
</body>
</html>