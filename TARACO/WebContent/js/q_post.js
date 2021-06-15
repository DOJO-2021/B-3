'use strict';


document.getElementById('post').onsubmit = function(event) {
	const delete_pw = document.getElementById('post').QUESTION_PASS.value;

	// 半角英数字8~16文字チェック
	if (!(delete_pw.match(/^([0-9]{4,4})$/))) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※パスワードは半角英数字4桁で入力してください';
	}
}