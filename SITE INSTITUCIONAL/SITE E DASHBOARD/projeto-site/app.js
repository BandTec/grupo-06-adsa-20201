process.env.NODE_ENV = 'production';

var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usuariosRouter = require('./routes/usuarios');
var leiturasRouter = require('./routes/leituras').rotas;
var dadosMaquina = require('./routes/dadosMaquina');
var dadosEstacoes = require('./routes/estacaoBD');
var dadosMaquinasEstacoes = require('./routes/estacaoMaquina');
// var maquina = require('./routes/rotaMaquina');
//var estacoes = require('./routes/estacoes');

var app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/usuarios', usuariosRouter);
app.use('/leituras', leiturasRouter);
app.use('/dados' , dadosMaquina);
app.use('/dadosEstacao', dadosEstacoes);
app.use('/maquinaEstacao', dadosMaquinasEstacoes);
// app.use('/maquina', maquina);
//app.use('./')

module.exports = app;
