/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Telas;

import com.mycompany.Oshi.CPU;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;


/**
 *
 * @author aluga.com
 */
public class InsereBanco {

    public static void main(String[] args) {
        
      SystemInfo si = new SystemInfo();
      
    CPU cpu = new CPU();
    
  
    Conexao con = new Conexao();
    JdbcTemplate template = new JdbcTemplate(con.getBanco());
    
    String CpuPorcent = cpu.getCurrentPercent().toString();
    String CpuMaximo = cpu.getFrequency().toString();
    String MediaCpu = cpu.getCurrentFrequency().toString();

    template.execute (
    "DROP TABLE IF EXISTS dadosMaquina");
        
        String criacao = "CREATE TABLE dadosMaquina("
            + "id INT PRIMARY KEY AUTO_INCREMENT,"
            + "CpuPorcent VARCHAR(250),"
            + "CpuMaximo VARCHAR(250),"
            + "MediaCpu VARCHAR(250))";

    template.execute (criacao);

    template.update (

    "INSERT INTO dadosMaquina VALUES(?,?,?,?)",null,CpuPorcent,CpuMaximo,MediaCpu);
    template.update (
    "INSERT INTO dadosMaquina VALUES(?,?,?,?)",null,CpuPorcent,CpuMaximo,MediaCpu);
          
            List resultados = template.queryForList("SELECT * FROM dadosMaquina");

    System.out.println (resultados);
}
}
