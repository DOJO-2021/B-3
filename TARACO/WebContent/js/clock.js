'use strict';
//時刻表示
function showTime() {
	let now = new Date();
	let year = now.getFullYear();
	let month = now.getMonth();
	let date = now.getDate();
	let nowTime = String(year) + "/" + String(month + 1) + "/" + String(date);
	document.getElementById('clock').textContent = nowTime;
	refresh();
}

function refresh() {
	setTimeout(showTime, 100);
}

showTime();