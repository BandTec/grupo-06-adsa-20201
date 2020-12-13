const connection = require('../config/connection');

module.exports = {
    async maquinas(req, res) {
        const maquina = await connection.raw(`select top (20) (id), (Nome_maquina), (CpuMaximo), (MediaCpu), (RamUsada), (RamDisponivel), 
        (discoTotal), (discoDisponi), (Statusrede), (dataConsulta), (fkEstacao)
                from dadosMaquinas where fkEstacao = 1 order by id desc;`);
        return res.json(maquina);
    }
};