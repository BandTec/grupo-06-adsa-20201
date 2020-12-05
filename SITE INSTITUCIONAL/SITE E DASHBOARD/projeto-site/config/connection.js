let knex = require('knex')({
    client: 'mssql',
    connection: {
        host: 'machinetechserver.database.windows.net',
        user: 'machinetechuser',
        password: '#Gfgrupo6',
        database: 'MachinetechBD'
    }
});

module. exports = knex;