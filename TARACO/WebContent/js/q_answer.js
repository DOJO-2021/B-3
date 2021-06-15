'use strict';
new Chart(document.getElementById('resultGraph'), {
	type: 'pie',
	options: {
		legend: {
			onClick: (e) => e.stopPropagation(),
			responsive: true,
			maintainAspectRatio: false
		}
	},
	data: {
		labels: ['Aの回答者', 'Bの回答者'],
		datasets: [
			{
				data: [30, 39],
				backgroundColor: [
					'rgb(255, 99, 132)',
					'rgb(54, 162, 235)'
				]
			}
		]
	}
});
//グレーアウトテスト用プログラム
function click() {
	if (document.getElementById('send_answer').disabled === true) {
		document.getElementById('send_answer').removeAttribute('disabled');
	} else {
		document.getElementById('send_answer').setAttribute('disabled',true);
		}
}
let action = document.getElementById('test_disabled');
action.addEventListener('click',click);

