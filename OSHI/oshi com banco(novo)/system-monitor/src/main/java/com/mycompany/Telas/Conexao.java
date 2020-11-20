package com.mycompany.Telas;

import org.apache.commons.dbcp2.BasicDataSource;


public class Conexao {

    private BasicDataSource banco;

    public Conexao() {
        this.banco = new BasicDataSource();
        this.banco.setDriverClassName("org.h2.Driver");
        this.banco.setUrl("jdbc:h2:file:./meu_banco");
        this.banco.setUsername("sa");
        this.banco.setPassword("");
    }

    public BasicDataSource getBanco() {
        return banco;
    }
    

}
