'use strict';
document.getElementById('form').onsubmit = function(event) {
	let adv_pw = document.getElementById('form').adv_pw.value;
	let pw_confirm = document.getElementById('form').pw_confirm.value;


	//空欄チェック
	if (adv_pw === "" || pw_confirm === "") {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※全ての欄に入力してください。';
	}// 半角英数字8~16文字チェック
	else if (!(adv_pw.match(/^([a-zA-Z0-9]{8,16})$/))) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※PWは半角英数字8～16文字で入力してください。';
	}// PWとPW確認欄の文字列が不一致の場合エラーメッセージを表示
	else if (adv_pw != pw_confirm) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※PWとPW確認が不一致です。';
	}
}