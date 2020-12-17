// Função p/ plotar o gráfico
function plotarCPU(leituraUsoPorc) {
    var ctx = document.getElementById("chartCPU").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "doughnut",
        data: {
            labels: [],
            datasets: [{
                label: "% de Utilização CPU",
                data: leituraUsoPorc,
                fill: true,
                backgroundColor: ['#2084f7', '#404363'],
                borderColor: ['#2084f7', '#404363']
            } ]
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






