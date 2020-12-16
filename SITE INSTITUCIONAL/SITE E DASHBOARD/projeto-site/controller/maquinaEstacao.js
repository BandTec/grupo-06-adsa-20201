const connection = require('../config/connection');

module.exports = {
    async maquinaEstacao(req, res) {
        const maquina = await connection.raw(`select (hostname) from  maquina where fkEstacao = 1;`);
        return res.json(maquina);
    }
};