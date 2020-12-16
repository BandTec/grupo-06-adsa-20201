const connection = require('../config/connection');
const maquina = require('../routes/leituras');
module.exports = {
    async maquinaEstacao(req, res) {
        console.log('maquinas do banco',maquina.maquina)
        const maquina1 = await connection.raw(`select (hostname) from  maquina where fkEstacao = ${maquina.maquina};`);
        
        return res.json(maquina1);
    }
};
