<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href = "/TARACO/css/profile.css">
<head>
<meta charset="UTF-8">
<title>TARACO</title>
</head>
<body>
	<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>

	<h1>マイページ</h1>
	<p>*は必須項目</p>

	<form method="POST" enctype="multipart/form-data" action="/TARACO/MyPageServlet">
		<table>
			<tr>
				<th>氏名*</th>
				<td><input type="text" name="USER_NAME" value="${myscope.user_name}"></td>
			</tr>
			<tr>
				<th>会社名or講師/事務局*</th>
				<td><input type="text" name="USER_POSITION" value="${myscope.user_position}"></td>
			</tr>

			<tr>
				<th>所属クラス</th>
				<td><input type="text" name="USER_CLASS" value="${myscope.user_class}"></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><input type="text" name="USER_GENDER" value="${myscope.user_gender}"></td>
			</tr>

			<tr>
				<th>出身の専攻</th>
				<td><input type="text" name="USER_MAJOR" value="${myscope.user_major}"></td>

			</tr>
			<tr>
				<th>趣味</th>
				<td><input type="text" name="USER_HOBBY" value="${myscope.user_hobby}"></td>
			</tr>
			<tr>
				<th>性格</th>
				<td><input type="text" name="USER_PERSONARITY" value="${myscope.user_personarity}"></td>
			</tr>
			<tr>
				<!--  星評価ってどうやるの？ -->
				<th>気にかけて欲しい度</th>
				<td>
					<div class="star">
						<input id="star5" type="radio" name="USER_STAR" value="5">
						<label for="star5">★</label>
						<input id="star4" type="radio" name="USER_STAR" value="4">
						<label for="star4">★</label>
						<input id="star3" type="radio" name="USER_STAR" value="3">
						<label for="star3">★</label>
						<input id="star2" type="radio" name="USER_STAR" value="2">
						<label for="star2">★</label>
						<input id="star1" type="radio" name="USER_STAR" value="1">
						<label for="star1">★</label>
					</div>
				</td>
			</tr>
			<tr>
				<th>備考※200字以内</th>
				<td><textarea name="USER_REMARKS" value="${myscope.user_remarks}"></textarea></td>
			</tr>
			<tr>
				<th>顔写真</th>
				<td><input type="file" name="USER_PHOTO" accept="image/*"></td>
			</tr>
			<tr>
				<td><input type="button" value="IDPW変更はこちら" onclick="clickBtn();"/></td>
			</tr>
		</table>


		<table id="adit_idpw">
				<tr>
					<th>ID
						<div class="msg" style="display: inline-block; _display: inline;">※8～16文字の半角英数字</div>
					</th>
				</tr>
				<tr>
					<td><input type="text" name="USER_ID" value="${myscope.user_id}"></td>
				</tr>
				<tr>
					<th>PW
						<div class="msg" style="display: inline-block; _display: inline;">※8～16文字の半角英数字</div>
					</th>
				</tr>
				<tr>
					<td><input type="password" name="USER_PW" value="${myscope.user_pw}"></td>
				</tr>
				<tr>
					<th>PW確認
						<div class="msg" style="display: inline-block; _display: inline;">※上記と同じ内容を入力してください</div>
					</th>
				</tr>
				<tr>
					<td><input type="password" name="PW_CONFIRM" value="${myscope.user_pw}"></td>
				</tr>
			</table>
		<input type="submit" name="MYPAGE_UPLODE" value="更新">
		<input type="submit" name="MYPAGE_DELETE" value="アカウント削除" onclick="Delete">
	</form>

	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
	<script src="/TARACO/js/mypage.js"></script>
</body>
</html>