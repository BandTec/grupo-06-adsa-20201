// Função p/ plotar o gráfico
function plotarMemoria(leituraUsoPorc) {
  var ctx = document.getElementById("chartMemoria").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "doughnut",
    data: {
      labels: ['% Uso de RAM', 'Espaço Vazio'],
      datasets: [
        {
          label: "% uso de RAM",
          data: leituraUsoPorc,
          fill: true,
          backgroundColor: ['blue', 'rgba(0,0,0,0.3)'],
          data: leituraUsoPorc,
          fill: false
        },
      ],
    },

    options: {
      cutoutPercentage: 80,
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
  fetch("http://localhost:3000/leituras/dadoMemoria", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let leitura = resposta;
          console.log(leitura);
          // quantidade de elementos dentro da lista
          console.log(leitura.recordsets[0].length);

          let leituraUsoPorc = [];

          for (n = leitura.recordsets[0].length - 1; n >= 0; n--) {
            leituraUsoPorc.push(leitura.recordsets[0][n].Ramporcentagem);
            leituraUsoPorc.push(100 - leitura.recordsets[0][n].Ramporcentagem);
          }
          console.log(leituraUsoPorc);

          plotarMemoria(leituraUsoPorc);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

  }

  atualizarMemoria();
