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
					value = value / count * 100;//数値をパーセント表示に変更
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

//グレーアウトプログラム
let elF = document.getElementById('answerPost');
let elG = document.getElementById('Graph');
let elR = dosument.getElementById('answer_result');
if (judge === 'true') {
	elF.style.display = 'none';
	elF.style.display = 'flex';
	elR.style.display = 'block';
}
//アンケート削除プログラム
function deleteQuestion() {
	let pw = window.prompt('削除用パスワードを入れて下さい。');
	if (pw !== pass) {
		event.preventDefault();
		alert("パスワードが違います！");
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
	return displayTimer;
}
function display() {
	const now = newDate();
	const post = getPostTime();
}
