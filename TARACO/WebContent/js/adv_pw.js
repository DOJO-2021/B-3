'use strict';
//運営PWを入力させるダイアログメッセージ→一致していればadv_regist.jspへ

document.getElementById("click").onclick = function() {
	var pw = window.prompt('運営用パスワードを入れて下さい。');

	if (pw === null) {	//キャンセル押されたらnullで返ってくる
		event.preventDefault();
		window.location.href = "AdviceSearchServlet";
	} else if (pw === pass) {	//passはjspで宣言済み15行目
		window.location.href = "ADVRegistServlet";
	} else {
		alert("パスワードが違います！");
		event.preventDefault();
		window.location.href = "AdviceSearchServlet";
	}
}