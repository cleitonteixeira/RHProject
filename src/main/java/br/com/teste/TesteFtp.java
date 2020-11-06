/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste;

import br.com.nutribemrefeicoescoletivas.ftp.FTPControl;
import java.io.IOException;


/**
 *
 * @author Cleiton
 */
public class TesteFtp {
    public static void main(String[] args) throws IOException  {
        String server = "ftp.nutribemrefeicoescoletivas.com.br";
        String usuario = "nutribemrefeicoescoletivas";
        String senha = "Nutri@1748";
       /* if(new FTPControl(server, usuario, senha).sendFTPFile("C:\\Users\\cleit\\Desktop\\apostila-java-web.pdf", "Boleto KingHost1.pdf")){
            System.out.println("Enviado");
        }else{
            System.out.println("Falha");
        }*/
        
        new FTPControl(server, usuario, senha).getFile("Boleto KingHost.pdf");
    }
}
