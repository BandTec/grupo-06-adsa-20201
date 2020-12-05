const connection = require('../config/connection');

module.exports = {
    async maquinas(req, res) {
        const maquina = await connection.raw(`select id, Nome_maquina,
        CpuMaximo, MediaCpu, RamUsada, RamDisponivel, discoTotal, discoDisponi, Statusrede, dataConsulta
        from dadosMaquinas order by id desc;`);
        return res.json(maquina);
    }
};