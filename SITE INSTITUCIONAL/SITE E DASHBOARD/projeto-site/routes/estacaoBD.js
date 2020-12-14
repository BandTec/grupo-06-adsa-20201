const express = require('express');
const router = express.Router();
const dadosEstacoes = require('../controller/estacao');

router.get('/Estacao', dadosEstacoes.estacoes);

module.exports = router;