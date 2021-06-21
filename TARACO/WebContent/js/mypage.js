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