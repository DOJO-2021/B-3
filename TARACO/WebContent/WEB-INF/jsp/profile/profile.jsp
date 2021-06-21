<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<!--<c:forEach var="e" items="${cardList}">-->
	<h1>${e.user_name}さんのプロフィール</h1>


		<table>
			<tr>
				<th>会社名or講師/事務局</th>
				<td><input type="text" name="USER_POSITION" value=" ${e.user_position}"></td>
			</tr>

			<tr>
				<th>所属クラス</th>
				<td><input type="text" name="USER_CLASS" value="${e.user_class}"></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><input type="text" name="USER_GENDER" value="${e.user_gender}"></td>
			</tr>

			<tr>
				<th>出身の専攻</th>
				<td><input type="text" name="USER_MAJOR" value="${e.user_major}"></td>

			</tr>
			<tr>
				<th>趣味</th>
				<td><input type="text" name="USER_HOBBY" value="${e.user_hobby}"></td>
			</tr>
			<tr>
				<th>性格</th>
				<td><input type="text" name="USER_PERSONARITY" value="${e.user_personarity}"></td>
			</tr>
			<tr>
				<!-- 星評価ってどうやるの？ -->
				<th>気にかけて欲しい度</th>

				<td>
						<div class="star">
						<input id="star5" type="radio" name="USER_STAR" value= "5">
						<label for="star5">★</label>
						<input id="star4" type="radio" name="USER_STAR" value= "4">
						<label for="star4">★</label>
						<input id="star3" type="radio" name="USER_STAR" value= "3">
						<label for="star3">★</label>
						<input id="star2" type="radio" name="USER_STAR" value= "2">
						<label for="star2">★</label>
						<input id="star1" type="radio" name="USER_STAR" value= "1">
						<label for="star1">★</label>
						</div>
						${e.user_star}
				</td>
			</tr>
			<tr>
				<th>備考※200字以内</th>
				<td><input type="text" name="USER_REMARKS" value="${e.user_remarks}"></td>
			</tr>
			<!-- <tr>
				<th>画像</th>
				<td><img src="" name="USER_PHOTO" value="${e.user_photo}"></td>
			</tr> -->
		</table>
		<!--</c:forEach>-->
	<!-- フッター -->
	<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>