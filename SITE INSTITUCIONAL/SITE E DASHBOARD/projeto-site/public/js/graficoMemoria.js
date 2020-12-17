// Função p/ plotar o gráfico
function plotarMemoria(leituraUsoPorc) {
    var ctx = document.getElementById("chartMemoria").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "doughnut",
        data: {
            labels: [],
            labels: [],
            datasets: [{
                label: [],
                data: leituraUsoPorc,
                fill: true,
                backgroundColor: ['#2084f7', '#404363'],
                borderColor: ['#2084f7', '#404363'],
                data: leituraUsoPorc,
                fill: false
            }, ],
        },

        options: {
            cutoutPercentage: 60,
            rotation: 180,
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                animationScale: true
            },
        },
    });
}




