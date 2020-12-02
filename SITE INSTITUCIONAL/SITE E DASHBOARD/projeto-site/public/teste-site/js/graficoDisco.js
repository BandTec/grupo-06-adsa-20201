// Função p/ plotar o gráfico
function plotarDisco(tempoLeitura, leituraUsoPorc) {
  var ctx = document.getElementById("chartDisco").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "doughnut",
    data: {
      // eixo X
      labels: tempoLeitura,
      datasets: [
        {
          label: "% de utilização memória",
          // eixo Y
          data: leituraUsoPorc,
          fill: true,
          backgroundColor: "rgba(170, 120, 166, 0.30)",
          borderColor: "rgba(170, 120, 166, 0.69)",
          borderWidth: 1,
        },
      ],
    },
    options: {
      responsive: true,
      scales: {
        yAxes: [
          {
            ticks: {
              beginAtZero: true,
            },
          },
        ],
      },
    },
  });
}

window.onload = atualizarMemoria();
function atualizarMemoria() {
  fetch("http://localhost:3000/leituras/dadoDisco", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          console.log(leitura);
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);
          // variavel do eixo y
          let leituraUsoPorc = [];
          // variavel do eixo x
          let tempoLeitura = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraUsoPorc.push(leitura.recordsets[0][n].discoTotal);
            tempoLeitura.push(leitura.recordsets[0][n].dataConsulta);
          }
          console.log(leituraUsoPorc);

          plotarDisco(tempoLeitura, leituraUsoPorc);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

  setTimeout(() => {
   atualizarMemoria();
  }, 5000);
}