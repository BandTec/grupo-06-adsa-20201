const connection = require('../config/connection');

module.exports = {
    async estacoes(req, res) {
        const estacao = await connection.raw(`select (nomeEstacao) from  estacao;`);
        return res.json(estacao);
    }
};