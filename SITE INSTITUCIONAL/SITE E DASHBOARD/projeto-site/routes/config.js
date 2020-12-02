var sql = require('mssql');

let dbConfig = {
	server: 'machinetechserver.database.windows.net',
	user: 'machinetechuser',
	password: '#Gfgrupo6',
	database: 'MachinetechBD',
	"options": {
		"encrypt": true,
		"enableArithAbort": true
	}
}

let connection = new sql.ConnectionPool(dbConfig);

connection.connect((err) => {
	if (err) throw err;
	console.log('Conexão bem sucedida com o Banco de Dados!')
})

module.exports = connection;