<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARACO</title>

<link rel="stylesheet" href="/TARACO/css/advice.css">
<link rel="stylesheet" href="/TARACO/css/common.css">

</head>
<body>
<header><jsp:include page="/WEB-INF/jsp/other/header.jsp" /></header>
<h1>アドバイス登録</h1>

<a href="/TARACO/ADVRegistServlet">新規登録</a>
<a href="/TARACO/ADVEditSearchServlet">既存データの編集</a>

<div class="pw">
<form method="GET" action="/TARACO/ADVPWServlet">
<input type="submit" name="REGIST" class="edit_login_button" value="PW変更はこちらから" ><br><br>
</form>
</div>

<form method="POST" action="/TARACO/ADVRegistServlet">
<table>
	<tr>
		<th>項目:</th>
		<td>
		<select name="adv_course">
		<option value="" hidden>コースを選択してください</option>
		<option value="パーソナルスキルコース">パーソナルスキルコース</option>
		<option value="IT基礎">IT基礎</option>
		<option value="Java基礎">Java基礎</option>
		<option value="開発演習">開発演習</option>
		</select>
		</td>
		<th>受講年度:</th>
		<td>
		<select name="adv_year">
		<option value="" hidden>-</option>
		<option value="1990">1990</option>
		<option value="1991">1991</option>
		<option value="1992">1992</option>
		<option value="1993">1993</option>
		<option value="1994">1994</option>
		<option value="1995">1995</option>
		<option value="1996">1996</option>
		<option value="1997">1997</option>
		<option value="1998">1998</option>
		<option value="1999">1999</option>
		<option value="2000">2000</option>
		<option value="2001">2001</option>
		<option value="2002">2002</option>
		<option value="2003">2003</option>
		<option value="2004">2004</option>
		<option value="2005">2005</option>
		<option value="2006">2006</option>
		<option value="2007">2007</option>
		<option value="2008">2008</option>
		<option value="2009">2009</option>
		<option value="2010">2010</option>
		<option value="2011">2011</option>
		<option value="2012">2012</option>
		<option value="2013">2013</option>
		<option value="2014">2014</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
		<option value="2021">2021</option>
		<option value="2022">2022</option>
		<option value="2023">2023</option>
		<option value="2024">2024</option>
		<option value="2025">2025</option>
		<option value="2026">2026</option>
		<option value="2027">2027</option>
		<option value="2028">2028</option>
		<option value="2029">2029</option>
		<option value="2030">2030</option>
		<option value="2031">2031</option>
		<option value="2032">2032</option>
		<option value="2033">2033</option>
		<option value="2034">2034</option>
		<option value="2035">2035</option>
		<option value="2036">2036</option>
		<option value="2037">2037</option>
		<option value="2038">2038</option>
		<option value="2039">2039</option>
		<option value="2040">2040</option>
		<option value="2041">2041</option>
		<option value="2042">2042</option>
		<option value="2043">2043</option>
		<option value="2044">2044</option>
		<option value="2045">2045</option>
		<option value="2046">2046</option>
		<option value="2047">2047</option>
		<option value="2048">2048</option>
		<option value="2049">2049</option>
		<option value="2050">2050</option>
		</select>　年
		</td>
	</tr>
	<tr>
		<th colspan="2">アドバイス本文<span class="small">※400字以内</span></th>
	</tr>
	<tr>
		<td colspan="4">
		<textarea name="adv_content" cols="65" rows="6">${e.adv_content}</textarea>
		</td>
	</tr>
</table>

<input type="submit" name="REGIST" value="新規登録"><br>
</form>

<br>
<footer><jsp:include page="/WEB-INF/jsp/other/footer.jsp" /></footer>
</body>
</html>