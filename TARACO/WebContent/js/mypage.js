'use strict';

function clickBtn(){
  var str = document.getElementById("adit_idpw");
  if(str.style.display == "none"){
    str.style.display = "block";
  }else{
    str.style.display = "none";
  }
}