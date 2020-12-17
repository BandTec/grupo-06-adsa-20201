package com.mycompany.API;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    Date data = new Date();

    private String dias = data.getDay() + "/" + data.getMonth() + "/" + data.getYear();
    private String horas = data.getHours() + ":" + data.getMinutes() + ":" + data.getSeconds();

    public void addLog(String destino, String tipo, String mensagem) {
        try (FileWriter criadorArquivo = new FileWriter(destino, true);
                BufferedWriter buffer = new BufferedWriter(criadorArquivo);
                PrintWriter escritorArquivo = new PrintWriter(buffer)) {
                escritorArquivo.append(dias + " " + horas + " " + tipo + ":" + mensagem + "\n");
                
        } catch (Exception ex) {
            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}