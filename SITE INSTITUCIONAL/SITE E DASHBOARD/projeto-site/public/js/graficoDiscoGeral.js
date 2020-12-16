// Função p/ plotar o gráfico
function plotarDiscoGeral(leituraUsoPorc) {
    var ctx = document.getElementById("chartDiscoGeral").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "doughnut",
        data: {
            labels: [],
            labels: ['Porcentagem de Uso'],
            datasets: [{
                label: ['Porcentagem de Uso'],
                data: leituraUsoPorc,
                fill: true,
                backgroundColor: ['#2084f7', '#404363'],
                borderColor: ['#2084f7', '#404363'],
                data: leituraUsoPorc,
                fill: false,
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

window.onload = atualizarMemoria();

function atualizarMemoria() {
    fetch("http://localhost:3000/leituras/dadoDisco", { cache: "no-store" })
        .then(function(response) {
            if (response.ok) {
                response.json().then(function(resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    let leitura = resposta;
                    console.log(leitura);
                    // quantidade de elementos dentro da lista
                    console.log(leitura.recordsets[0].length);

                    let leituraUsoPorc = [];

                    for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
                        leituraUsoPorc.push(leitura.recordsets[0][n].Discoporcentagem);
                        leituraUsoPorc.push(100 - leitura.recordsets[0][n].Discoporcentagem);
                    }
                    console.log(leituraUsoPorc);

                    plotarDiscoGeral(leituraUsoPorc);
                });
            } else {
                console.error("Nenhum dado encontrado ou erro na leituras");
            }
        })
        .catch(function(error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });

}
atualizarMemoria();