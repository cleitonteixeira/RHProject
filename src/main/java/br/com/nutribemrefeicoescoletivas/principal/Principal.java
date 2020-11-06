/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nutribemrefeicoescoletivas.principal;

import br.com.nutribemrefeicoescoletivas.tools.Criptografia;
import br.com.nutribemrefeicoescoletivas.view.LoginViewer;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
                if ( "Metal".equals( info.getName() ) ) {
                    UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException exc ) {
        }
        LoginViewer entrar = new LoginViewer();
        System.out.println(new Criptografia().criptografa("35616110"));
        entrar.setVisible(true);
        
    }
}