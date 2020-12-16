const connection = require('../config/connection');

module.exports = {
    async estacoes(req, res) {
        const estacao = await connection.raw(`select (nomeEstacao), (idEstacao) from  estacao;`);
        return res.json(estacao);
    }
};