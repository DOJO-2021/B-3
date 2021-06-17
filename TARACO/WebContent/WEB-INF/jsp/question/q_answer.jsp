<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<!-- グラフ描画用jsと追加機能js 外部参照 -->
<script>
const date = "${question.q_date}"";
const count = Number(${question.a_responses});
const countA = Number(${question.a_responses_a});
const answer_a = "${question.q_choice_a}";
const answer_b = "${question.q_choice_b}";
const pass = "${question.q_pw}";
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js">
</script>
<script src="/TARACO/js/chartjs-plugin-datalabels.min.js"></script>
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
	<table class="answer_table2">
		<tr>
			<th>合計${question.a_responses}人</th>
			<th>Aの回答${question.a_responses_a}人</th>
			<th>Bの回答${question.a_responses_b}人</th>
		</tr>
	</table>
	<p></p>
	<div class="Graph" id="Graph">
		<canvas id="resultGraph"Width = "600" height = "300"></canvas>
	</div>
	<form method="POST" action="/TARACO/QAnswerServlet" method="post">
		<label> <input id="select_answer" type="radio" name="ANSWER"
			value="A" required>${question.q_choice_a}
		</label><label> <input id="select_answer" type="radio" name="ANSWER"
			value="B">${question.q_choice_b}
		</label> <input id="send_answer" type="submit" name="POST_QUESTION"
			value="アンケート投稿" disabled>
	</form>
	<input id="test_disabled" type="button" value="切り替え">
	<script src="/TARACO/js/q_answer.js"></script>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>