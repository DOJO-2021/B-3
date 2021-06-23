'use strict';

let val = document.getElementById("stars").value;
console.log(typeof(val));
if (val === 1){
	document.getElementById("star1").style.color='yellow';
	document.getElementById("star2").style.color='black';
	document.getElementById("star3").style.color='black';
	document.getElementById("star4").style.color='black';
	document.getElementById("star5").style.color='black';
}

else if(val === '2'){
	document.getElementById("star1").style.color='yellow';
	document.getElementById("star2").style.color='yellow';
	document.getElementById("star3").style.color='black';
	document.getElementById("star4").style.color='black';
	document.getElementById("star5").style.color='black';
}

else if(val === '3'){
	document.getElementById("star1").style.color='yellow';
	document.getElementById("star2").style.color='yellow';
	document.getElementById("star3").style.color='yellow';
	document.getElementById("star4").style.color='black';
	document.getElementById("star5").style.color='black';
}

else if(val === '4'){
	document.getElementById('star1').style.color='yellow';
	document.getElementById("star2").style.color='yellow';
	document.getElementById("star3").style.color='yellow';
	document.getElementById("star4").style.color='yellow';
	document.getElementById("star5").style.color='black';
}

else if(val === '5'){
	document.getElementById("star1").style.color='yellow';
	document.getElementById("star2").style.color='yellow'
	document.getElementById("star3").style.color='yellow'
	document.getElementById("star4").style.color='yellow'
	document.getElementById("star5").style.color='yellow'
}

function clickBtn(){
  var str = document.getElementById("adit_idpw");
  if(str.style.display === "none"){
    str.style.display = "block";
  }else{
    str.style.display = "none";
  }
}


function Update() {

	const user_id = document.getElementById('form').USER_ID.value;
	const user_pw = document.getElementById('form').USER_PW.value;

		console.log(user_id);
		console.log(user_pw);

	// 半角英数字8~16文字チェック
	if (!(user_id.match("^([a-zA-Z0-9]{8,16})$") && user_pw.match("^([a-zA-Z0-9]{8,16})$"))) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = `※IDとPWを半角英数字8～16文字で入力してください`;
	}

	if (user_pw != pw_confirm) {
		event.preventDefault();
		document.getElementById('errormsg').textContent = '※PWとPW確認が不一致です。';
	}
}

function Delete() {
	if(!window.confirm("自身のアカウントを削除しますか？")){
		event.preventDefault();
	}
}