const express = require('express');
const router = express.Router();
const dadosEstacoes = require('../controller/maquinaEstacao');

router.get('/maquinaEstacao', dadosEstacoes.maquinaEstacao);

module.exports = router;