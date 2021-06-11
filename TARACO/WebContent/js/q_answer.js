'use strict';
var canvus = document.getElementById("resultGraph");
canvus.width = 100;
new Chart(canvus, {
	type: "pie",
	options: {
		legend: {
			onClick: (e) => e.stopPropagation()
		}
	},
	data: {
		labels: ["Aの回答者", "Bの回答者"],
		datasets: [
			{
				data: [30, 39],
				backgroundColor: [
					"rgb(255, 99, 132)",
					"rgb(54, 162, 235)"
				]
			}
		]
	}
});

