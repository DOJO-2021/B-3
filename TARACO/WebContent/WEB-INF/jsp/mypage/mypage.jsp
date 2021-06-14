<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<td><input type="text" name="USER_NAME"></td>
			</tr>
			<tr>
				<th>会社名or講師/事務局*</th>
				<td><input type="text" name="USER_POSITION"></td>
			</tr>

			<tr>
				<th>所属クラス</th>
				<td><input type="text" name="USER_CLASS"></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><input type="text" name="USER_GENDER"></td>
			</tr>

			<tr>
				<th>出身の専攻</th>
				<td><input type="text" name="USER_MAJOR"></td>

			</tr>
			<tr>
				<th>趣味</th>
				<td><input type="text" name="USER_HOBBY"></td>
			</tr>
			<tr>
				<th>性格</th>
				<td><input type="text" name="USER_PERSONARITY"></td>
			</tr>
			<tr>
				<!--  星評価ってどうやるの？ -->
				<th>気にかけて欲しい度</th>
				<td>
					<div class="star">
						<input type="radio" name="USER_STAR" value="5">
						<label for="star5">★</label>
						<input type="radio" name="USER_STAR" value="4">
						<label for="star4">★</label>
						<input type="radio" name="USER_STAR" value="3">
						<label for="star3">★</label>
						<input type="radio" name="USER_STAR" value="2">
						<label for="star2">★</label>
						<input type="radio" name="USER_STAR" value="1">
						<label for="star1">★</label>
					</div>
				</td>
			</tr>
			<tr>
				<th>備考※200字以内</th>
				<td><input type="text" name="USER_REMARKS"
					value="${e.user_remarks}"></td>
			</tr>
			<tr>
				<th>顔写真</th>
				<td><input type="file" name="USER_PHOTO" accept="image/*"></td>
			</tr>
		</table>
	</form>
	<input type="submit" name="SUBMIT" value="更新">
	<input type="submit" name="SUBMIT" value="アカウント削除">
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>