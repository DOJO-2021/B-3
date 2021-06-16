'use strict';
//運営PWを入力させるダイアログメッセージ→一致していればadv_regist.jspへ


document.getElementById("click").onclick = function() {
	var pw = window.prompt("運営用パスワードを入れて下さい。", "");
	if (pw == "SamplePassword") {
		window.location.href = "ADVRegistServlet";
	} else {
		alert("パスワードが違います！");
		window.location.href = "AdviceSearchServlet";
	}
}