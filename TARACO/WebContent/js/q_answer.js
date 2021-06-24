'use strict';

let config = {
	type: 'pie',
	data: {
		labels: [
			answer_a,
			answer_b
		],
		datasets: [
			{
				data: [countA, count - countA],
				backgroundColor: [
					'rgb(255, 99, 132)',
					'rgb(54, 162, 235)'
				]
			}],
	},
	options: {
		responsive: false,
		legend: {
			onClick: (e) => e.stopPropagation(),
			responsive: true,
			maintainAspectRatio: false
		},
		plugins: {
			datalabels: {
				color: '#000',
				font: {
					weight: 'bold',
					size: 20,
				},
				formatter: (value, ctx) => {
					value = Math.round(value / count * 100 * 10) / 10;//数値をパーセント表示に変更
					return value + '%';
				},
			}
		}
	}
};
window.addEventListener('load', function() {
	let ctx = document.getElementById('resultGraph').getContext('2d');
	const resultGraph = new Chart(ctx, config);
}, false);


//アンケート削除プログラム
function deleteQuestion() {
	if (user !== post_user) {
		event.preventDefault();
		alert("アンケート削除ができるのは投稿者のみです。");
	} else {

		let pw = window.prompt('削除用パスワードを入れて下さい。');
		if (pw !== pass) {
			event.preventDefault();
			alert("パスワードが違います！");
		}
	}
}

function getPostTime() {
	const displayTimer = [
		Number(date.replace(/[^0-9]/g, '').substring(0, 4)),
		Number(date.replace(/[^0-9]/g, '').substring(4, 6)),
		Number(date.replace(/[^0-9]/g, '').substring(6, 8)),
		Number(date.replace(/[^0-9]/g, '').substring(8, 10)),
		Number(date.replace(/[^0-9]/g, '').substring(10, 12)),
		Number(date.replace(/[^0-9]/g, '').substring(12, 14))
	];
	let displayTimerDate = new Date();
	displayTimerDate.setFullYear(displayTimer[0]);
	displayTimerDate.setMonth(displayTimer[1] - 1);
	displayTimerDate.setDate(displayTimer[2] + 1);
	displayTimerDate.setHours(displayTimer[3]);
	displayTimerDate.setMinutes(displayTimer[4]);
	displayTimerDate.setSeconds(displayTimer[5]);
	return displayTimerDate;
}
let postJudge = true;
function display() {
	const now = new Date();
	const post = getPostTime();
	let deadline = [
		Math.floor((post - now) / 1000 / 60 / 60) % 24,
		Math.floor((post - now) / 1000 / 60) % 60,
		Math.floor((post - now) / 1000) % 60
	];
	deadline[0] = String(deadline[0]).padStart(2, '0');
	deadline[1] = String(deadline[1]).padStart(2, '0');
	deadline[2] = String(deadline[2]).padStart(2, '0');
	const timedis = `残り${deadline[0]}時間${deadline[1]}分${deadline[2]}秒`;
	if (post - now >= 0) {
		timer.innerHTML = timedis;
	} else {
		timer.innerHTML = '回答受付を終了しています。';
		judge = 'true';
	}
	//非表示/表示プログラム
	judgeAnswer();
	refresh();
}

function refresh() {
	setTimeout(display, 500);
}
function judgeAnswer() {
	let elF = document.getElementById('answerPost');
	let elG = document.getElementById('Graph');
	let elR1 = document.getElementById('answer_result1');
	let elR2 = document.getElementById('answer_result2');
	console.log(judge);
	if (judge === 'true') {
		elF.style.display = 'none';
		elR1.style.display = 'none';
		elR2.style.display = 'block';
		if (count > 0) {
			elG.style.display = 'flex';
		}
		else {
			elF.style.display = 'block';
			elR1.style.display = 'block';
			elR2.style.display = 'none';
			elG.style.display = 'none';
		}
	}

}
display();


