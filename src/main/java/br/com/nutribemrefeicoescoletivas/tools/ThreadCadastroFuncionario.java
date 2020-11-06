package br.com.nutribemrefeicoescoletivas.tools;

import br.com.nutribemrefeicoescoletivas.bean.UsuarioBean;
import br.com.nutribemrefeicoescoletivas.dao.UsuarioDao;
import br.com.nutribemrefeicoescoletivas.view.RHPrincipal;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

/**
 *
 * @author Cleiton
 */
public class ThreadCadastroFuncionario implements Runnable{

    public JProgressBar jb;
    public JFrame f;
    public JLabel tf;
    public UsuarioBean user = new UsuarioBean();

    public ThreadCadastroFuncionario( JProgressBar jb, JFrame f, JLabel tf , Object user){
        this.user = (UsuarioBean) user;
        this.jb = jb;
        this.tf = tf;
        this.f = f;
        new Thread( this ).start();
    }
    
    @Override
    public void run() {
        try {
            if(new UsuarioDao().logar(user)){
                tf.setText("Iniciando Sistema...");
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(13);
                    jb.setValue(i); 
                    switch (i){
                        case 10:
                            tf.setText("Conectando Banco de dados...");
                            break;
                        case 35:
                            tf.setText("Verificando Integridade...");
                            break;
                        case 75:
                            tf.setText("Carregando Módulos...");
                            break;
                        case 87:
                            tf.setText("Abrindo Sistema...");
                            break;
                    }                   
                }
                Thread.sleep(750);
                RHPrincipal rp = new RHPrincipal();
                rp.RecebeDados(user);
                rp.setVisible(true);
                f.dispose();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.out.println("Puxa, estava dormindo! Você me acordou");
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(ThreadCadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
