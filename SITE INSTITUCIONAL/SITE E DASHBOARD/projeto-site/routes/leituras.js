var express = require('express');
const db = require('./config');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;
var path = require("path");
var maquinas;

/* Recuperar as últimas N leituras */
// router.get('/ultimas', function(req, res, next) {

// 	// quantas são as últimas leituras que quer? 8 está bom?
// 	const limite_linhas = 7;

// 	console.log(`Recuperando as últimas ${limite_linhas} leituras`);

// 	const instrucaoSql = `select top ${limite_linhas} 
// 						temperatura, 
// 						umidade, 
// 						momento,
// 						FORMAT(momento,'HH:mm:ss') as momento_grafico 
// 						from leitura order by id desc`;

// 	sequelize.query(instrucaoSql, {
// 		model: Leitura,
// 		mapToModel: true 
// 	  })
// 	  .then(resultado => {
// 			console.log(`Encontrados: ${resultado.length}`);
// 			res.json(resultado);
// 	  }).catch(erro => {
// 			console.error(erro);
// 			res.status(500).send(erro.message);
// 	  });
// });


// tempo real (último valor de cada leitura)
// router.get('/tempo-real', function (req, res, next) {

// 	console.log(`Recuperando a última leitura`);

// 	const instrucaoSql = `select top 1 temperatura, umidade, FORMAT(momento,'HH:mm:ss') as momento_grafico  
// 						from leitura order by id desc`;

// 	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
// 		.then(resultado => {
// 			res.json(resultado[0]);
// 		}).catch(erro => {
// 			console.error(erro);
// 			res.status(500).send(erro.message);
// 		});

// });


// estatísticas (max, min, média, mediana, quartis etc)
// router.get('/estatisticas', function (req, res, next) {

// 	console.log(`Recuperando as estatísticas atuais`);

// 	const instrucaoSql = `select 
// 							max(temperatura) as temp_maxima, 
// 							min(temperatura) as temp_minima, 
// 							avg(temperatura) as temp_media,
// 							max(umidade) as umidade_maxima, 
// 							min(umidade) as umidade_minima, 
// 							avg(umidade) as umidade_media 
// 						from leitura`;

// 	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
// 		.then(resultado => {
// 			res.json(resultado[0]);
// 		}).catch(erro => {
// 			console.error(erro);
// 			res.status(500).send(erro.message);
// 		});

// });

router.get('/dadoDisco', (request, response) => {
    var sql = `select Discoporcentagem from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'PrimeiraMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
// teste 
router.get('/dadoDisco1', (request, response) => {
    var sql = `select top [10] [Discoporcentagem] from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'SegundaMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
router.get('/dadoDisco2', (request, response) => {
    var sql = `select Discoporcentagem from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'TerceiraMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});


router.get('/maquinaAtual/:id', function (req, res) {
    console.log("A maquina: " + maquinas)
    maquinas = req.params.id;
});

router.get('/dadoMaquinaEstacao', (request, response) => {
    var sql = `select (hostname) from  maquina where fkEstacao = ${maquinas};`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
router.get('/graficoAtual/:fk', function (req, res){
    console.log("O gráfico: " + maquinas)
});

router.get('/dadoGraficoMaquina', (request, response) => {
    var sql = `select (CpuPorcent), (Ramporcentagem), (Discoporcentagem) from dadosMaquinas where fkMaquina = ${maquinas}`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/dadoCPU', (request, response) => {
    var sql = `select CpuPorcent from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'PrimeiraMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
// teste
router.get('/dadoCPU1', (request, response) => {
    var sql = `select CpuPorcent from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'SegundaMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
router.get('/dadoCPU2', (request, response) => {
    var sql = `select CpuPorcent from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'SegundaMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});


router.get('/dadoMemoria', (request, response) => {
    var sql = `select Ramporcentagem from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'PrimeiraMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
// teste
router.get('/dadoMemoria1', (request, response) => {
    var sql = `select Ramporcentagem from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'SegundaMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});

router.get('/dadoMemoria2', (request, response) => {
    var sql = `select Ramporcentagem from dadosMaquinas where id = (SELECT MAX(id) FROM dadosMaquinas where Nome_maquina = 'TerceiraMaquina');`;
    db.query(sql, function(err, result) {
        if (err) throw err;
        response.json(result);
    });
});
module.exports = {
    'rotas': router, 
    'maquina': maquinas
};