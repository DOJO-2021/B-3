'use strict';
// いずれかの欄が空白の場合エラーメッセージを表示

document.getElementById('form').onsubmit = function(event) {
	const user_name = document.getElementById('form').USER_NAME.value;
	const user_position = document.getElementById('form').USER_POSITION.value;
	const user_id = document.getElementById('form').USER_ID.value;
	const_user_password = document.getElementById('form').USER_PW.value;

	if (user_name === "" || user_position === "" || user_id === "" || user_password === "") {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※全ての欄に入力してください';
	}
}
// PWとPW確認欄の文字列が不一致の場合エラーメッセージを表示
function CheckPassword(pw_confirm) {
	const user_password = document.getElementById('form').USER_PW.value;
	const pw_confirm =  document.getElementById('form').pw_confirm.value;
	if(user_password != pw_confirm){
	event.preventDefault();
	document.getElementById('errormsg').textContent = 'PWとPW確認が不一致です。';
	}
}