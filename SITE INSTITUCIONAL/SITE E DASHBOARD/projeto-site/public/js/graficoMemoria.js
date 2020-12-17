// Função p/ plotar o gráfico
function plotarMemoria(leituraUsoPorc) {
    var ctx = document.getElementById("chartMemoria").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "doughnut",
        data: {
            labels: [],
            labels: ['Porcentagem de Uso', "Espaço Livre"],
            datasets: [{
                label: ['Porcentagem de Uso', 'Espaço Livre'],
                data: leituraUsoPorc,
                fill: true,
                backgroundColor: ['#2671ce', '#dadada'],
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




