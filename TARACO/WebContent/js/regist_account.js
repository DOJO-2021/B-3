'use strict';

//空欄チェック
document.getElementById('form').onsubmit = function(event) {
	const user_name = document.getElementById('form').USER_NAME.value;
	const user_position = document.getElementById('form').USER_POSITION.value;
	const user_id = document.getElementById('form').USER_ID.value;
	const_user_pw = document.getElementById('form').USER_PW.value;

	if (user_name === "" || user_position === "" || user_id === "" || user_pw === "") {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※全ての欄に入力してください';
	}
}
// 半角英数字8~16文字チェック
if (!(user_id.match(/^([a-zA-Z0-9]{8,16})$/) || user_pw.match(/^([a-zA-Z0-9]{8,16})$/))) {
	event.preventDefault();
	document.getElementById('errormsg').textContent = '※IDとPWは半角英数字8～16文字で入力してください';
}

// PWとPW確認欄の文字列が不一致の場合エラーメッセージを表示
function CheckPassword(pw_confirm) {
	const user_password = document.getElementById('form').USER_PW.value;
	const pw_confirm = document.getElementById('form').pw_confirm.value;
	if (user_password != pw_confirm) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = 'PWとPW確認が不一致です。';
	}
}