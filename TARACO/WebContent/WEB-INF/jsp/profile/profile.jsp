<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>
<link rel="stylesheet" href = "/TARACO/css/profile.css">
</head>
<body>
	<!-- ヘッダー -->
	<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>

	<h1>○○さんのプロフィール</h1>
	<p>*は必須項目</p>

		<table>
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
				<!-- 星評価ってどうやるの？ -->
				<th>気にかけて欲しい度</th>
				<td>
					<div class="star">
						<input type="radio" name="USER_STAR">
						<label for="star5">★</label>
						<input type="radio" name="USER_STAR">
						<label for="star4">★</label>
						<input type="radio" name="USER_STAR">
						<label for="star3">★</label>
						<input type="radio" name="USER_STAR">
						<label for="star2">★</label>
						<input type="radio" name="USER_STAR">
						<label for="star1">★</label>
					</div>
				</td>
			</tr>
			<tr>
				<th>備考※200字以内</th>
				<td><input type="text" name="USER_REMARKS"></td>
			</tr>
		</table>
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>