const express = require('express');
const router = express.Router();
const dadosMaquina = require('../controller/dadosMaquina');

router.get('/Maquinas', dadosMaquina.maquinas);

module.exports = router;