'use strict';
//ログイン画面空欄の場合エラーメッセージを表示

document.getElementById('form').onsubmit = function(event) {
	const user_id = document.getElementById('form').USER_ID.value;
	const user_pw = document.getElementById('form').USER_PW.value;
	if (user_id === "" || user_password === "") {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※IDとPWを入力してください';
	}
}

// 半角英数8～16文字の正規表現 /^([a-zA-Z0-9]{8,16})$/

