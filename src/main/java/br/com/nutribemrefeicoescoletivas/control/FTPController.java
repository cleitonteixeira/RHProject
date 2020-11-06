package br.com.nutribemrefeicoescoletivas.control;

import br.com.nutribemrefeicoescoletivas.bean.ArquivoBean;
import br.com.nutribemrefeicoescoletivas.ftp.FTPControl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FTPController {
    
    private final String server = "ftp.nutribemrefeicoescoletivas.com.br";
    private final String usuario = "nutribemrefeicoescoletivas";
    private final String senha = "Nutri@1748";
    boolean rt = false;

    
    public boolean Enviar( Object obj ) throws IOException, SQLException{
        ArquivoBean arq = (ArquivoBean) obj;
        if (new FTPControl( server, usuario, senha ).setFile( arq )){
            try {

                rt = new ArquivoController().salvar(obj);

            } catch (SQLException ex) {
                
                Logger.getLogger(FTPController.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        return rt;
    }
}
