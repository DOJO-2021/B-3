<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<link rel="stylesheet" href="/TARACO/css/question.css">
</head>
<body>
	<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1>回答/集計</h1>
	<a class="deleteQuestion">削除</a>
	<p class="deadlineTimer" id="timer"></p>

	<table class="answer_table">
		<tr>
			<th>投稿者:</th>
			<td>${question.q_user}</td>
		</tr>
		<tr>
			<th>質問内容:</th>
			<td class="questionSentences">${question.q_content}</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>合計79人</th>
			<th>Aの回答30人</th>
			<th>Bの回答39人</th>
		</tr>
	</table>
	<div class="Graph">
		<canvas id="resultGraph"></canvas>
	</div>
	<form method="POST" action="/TARACO/QAnswerServlet" method="post">
		<label> <input id="select_answer" type="radio" name="ANSWER"
			value="A" required>Aの回答
		</label><label> <input id="select_answer" type="radio" name="ANSWER"
			value="B">Bの回答
		</label> <input id="send_answer" type="submit" name="POST_QUESTION" value="アンケート投稿"
			disabled>
	</form>
	<input id="test_disabled" type="button" value="切り替え">
	<script src="/TARACO/js/q_answer.js"></script>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>