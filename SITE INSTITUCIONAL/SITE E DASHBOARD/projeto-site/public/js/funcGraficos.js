window.onload = atualizarMemoria();
function atualizarMemoria() {
    fetch("http://localhost:3000/leituras/dadoGraficoMaquina", { cache: "no-store" })
        .then(function(response) {
            if (response.ok) {
                response.json().then(function(resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    let leitura = resposta;
                    console.log(leitura);
                    // quantidade de elementos dentro da lista
                    console.log(leitura.recordsets[0].length);

                    let leituraUsoPorc = [];
                        leituraUsoPorc.push(leitura.recordsets[0].CpuPorcent);
                        leituraUsoPorc.push(100 - leitura.recordsets[0].CpuPorcent);
                    
                    var leituraCPU = [];
                    leituraCPU.push(leitura.recordsets[0][0].CpuPorcent);
                    numeroCPU.innerHTML = `${Number(leitura.recordsets[0][0].CpuPorcent).toFixed(1)}% `;
                    leituraCPU.push(100 - leitura.recordsets[0][0].CpuPorcent);
                    var leituraMemoria = [];
                    leituraMemoria.push(leitura.recordsets[0][0].Ramporcentagem);
                    numeroMemoria.innerHTML = `${Number(leitura.recordsets[0][0].Ramporcentagem).toFixed(1)}% `;
                    leituraMemoria.push(100 - leitura.recordsets[0][0].Ramporcentagem);
                    var leituraDisco = [];
                    leituraDisco.push(leitura.recordsets[0][0].Discoporcentagem);
                    numeroDisco.innerHTML = `${Number(leitura.recordsets[0][0].Discoporcentagem).toFixed(1)}% `;
                    leituraDisco.push(100 - leitura.recordsets[0][0].Discoporcentagem);

                    plotarCPU(leituraCPU);
                    plotarDisco(leituraDisco);
                    plotarMemoria(leituraMemoria);
                });
            } else {
                console.error("Nenhum dado encontrado ou erro na leituras");
            }
        })
        .catch(function(error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });

}
setInterval(() => {
    atualizarMemoria();
}, 5000);
