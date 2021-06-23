'use strict';


document.getElementById('form').onsubmit = function(event) {
	const user_id = document.getElementById('form').USER_ID.value;
	const user_pw = document.getElementById('form').USER_PW.value;

	// 半角英数字8~16文字チェック
	if (!(user_id.match(/^([a-zA-Z0-9]{8,16})$/) && user_pw.match(/^([a-zA-Z0-9]{8,16})$/))) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = `※IDとPWを半角英数字8～16文字で入力してください`;
	}
}


