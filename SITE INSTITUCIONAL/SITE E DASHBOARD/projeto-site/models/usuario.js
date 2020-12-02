'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		// id: {
		// 	field: 'id',
		// 	type: DataTypes.INTEGER,
		// 	primaryKey: true,
		// 	autoIncrement: true
		// }		
		nomeCompleto: {
			field: 'nomeCompleto',
			type: DataTypes.STRING,
			allowNull: false
		},
		email: {
			field: 'email',
			type: DataTypes.STRING,
			allowNull: false
		},
		senha: {
			field: 'senha',
			type: DataTypes.STRING,
			allowNull: false
		},
		telefoneCelular: {
			field: 'telefoneCelular',
			type: DataTypes.STRING,
			allowNull: false
		},
		fotoPerfil: {
			field: 'fotoPerfil',
			type: DataTypes.STRING,
			allowNull: false
		},
	}, 
	{
		tableName: 'Cadastro', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
