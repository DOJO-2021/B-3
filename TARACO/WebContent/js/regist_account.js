'use strict';
document.getElementById('form').onsubmit = function(event) {
	let user_name = document.getElementById('form').USER_NAME.value;
	let user_position = document.getElementById('form').USER_POSITION.value;
	let user_id = document.getElementById('form').USER_ID.value;
	let user_pw = document.getElementById('form').USER_PW.value;
	let pw_confirm = document.getElementById('form').PW_CONFIRM.value;

	//空欄チェック
	if (user_name === "" || user_position === "" || user_id === "" || user_pw === "" || pw_confirm === "") {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※全ての欄に入力してください。';
	}// 半角英数字8~16文字チェック
	else if (!(user_id.match(/^([a-zA-Z0-9]{8,16})$/) || user_pw.match(/^([a-zA-Z0-9]{8,16})$/))) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※IDとPWは半角英数字8～16文字で入力してください。';
	}// PWとPW確認欄の文字列が不一致の場合エラーメッセージを表示
	else if (user_pw != pw_confirm) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※PWとPW確認が不一致です。';
	}
}