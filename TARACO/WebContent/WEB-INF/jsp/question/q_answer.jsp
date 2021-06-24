<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<!-- グラフ描画用jsと追加機能js 外部参照 -->
<script>
const judge = "${question.a_already}";
const date = "${question.q_date}";
const count = Number(${question.a_responses});
const countA = Number(${question.a_responses_a});
const answer_a = "${question.q_choice_a}";
const answer_b = "${question.q_choice_b}";
const pass = "${question.q_pw}";
const post_user = "${question.q_user}";
const user = "${question.user_id}";
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js">
</script>
<script src="/TARACO/js/chartjs-plugin-datalabels.min.js"></script>
<link rel="stylesheet" href="/TARACO/css/question.css">
<link rel="shortcut icon" href="/TARACO/images/favicon.ico">
</head>
<body>
	<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
	<h1>回答/集計</h1>
	<form method="POST" action="/TARACO/QAnswerServlet">
		<div class="deleteButton">
			<input type="hidden" name="Q_ID" value="${question.q_id}"> <input
				type="submit" onclick="deleteQuestion()" name="ANSWER_QUESTION" value="削除">
		</div>
	</form>

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
	<div class="answer_result2" id="answer_result2">
		<table class="answer_table2">
			<tr>
				<th>合計${question.a_responses}人</th>
				<th>Aの回答${question.a_responses_a}人</th>
				<th>Bの回答${question.a_responses_b}人</th>
			</tr>
		</table>
	</div>
	<p class="answer_result1" id="answer_result1">現在${question.a_responses}人が回答</p>
	<div class="Graph" id="Graph">
		<canvas id="resultGraph" Width="600" height="300"></canvas>
	</div>

	<form method="POST" action="/TARACO/QAnswerServlet" id="answerPost"
		class="answerPost">
		<label> <input id="select_answer" type="radio" name="ANSWER"
			value="A" required>${question.q_choice_a}
		</label><label> <input id="select_answer" type="radio" name="ANSWER"
			value="B">${question.q_choice_b}
		</label> <input type="hidden" name="Q_ID" value="${question.q_id}"> <input
			id="send_answer" type="submit" name="ANSWER_QUESTION" value="回答">
	</form>
	<script src="/TARACO/js/q_answer.js"></script>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>