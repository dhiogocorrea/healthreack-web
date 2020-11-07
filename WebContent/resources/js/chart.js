$(document).ready(function () {
    new Chart(document.getElementById("pie-chart-calorias"), {
        type: 'pie',
        data: {
            labels: ["Jantar", "Café da manhã", "Lanche", "Almoço"],
            datasets: [{
                label: "Média de calorias por refeição.",
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9"],
                data: [730, 260, 430, 784]
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Média de calorias por refeição'
            }
        }
    });

    new Chart(document.getElementById("line-chart-peso"), {
        type: 'line',
        data: {
          labels: ['11/03','27/03','07/04','23/04','01/05','06/05','10/05','16/06','01/06'],
          datasets: [ { 
              data: [76.5,75,74.3,73.9,73.2,71.1,72,71.2,70.4],
              label: "Kg",
              borderColor: "#8e5ea2",
              fill: false
            }
          ]
        },
        options: {
          title: {
            display: true,
            text: 'Histórico de peso'
          }
        }
     });
    
    new Chart(document.getElementById("pie-chart-exercicios"), {
        type: 'bar',
        data: {
            labels: ["Corrida", "Basquete", "Natação", "Futebol"],
            datasets: [{
                label: "Histórico de exercícios executados",
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9"],
                data: [20, 2, 15, 52]
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Histórico de exercícios executados'
            }
        }
    });

    
    new Chart(document.getElementById("line-chart-batimentos"), {
        type: 'line',
        data: {
          labels: ['11/03','27/03','07/04','23/04','01/05','06/05','10/05','16/06','01/06'],
          datasets: [ { 
              data: [76, 80, 75, 72, 89, 74, 75, 80, 81],
              label: "BPM",
              borderColor: "#8e5ea2",
              fill: false
            }
          ]
        },
        options: {
          title: {
            display: true,
            text: 'Histórico de batimentos'
          }
        }
     });
});