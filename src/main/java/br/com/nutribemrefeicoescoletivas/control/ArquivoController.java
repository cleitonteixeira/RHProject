package br.com.nutribemrefeicoescoletivas.control;

import br.com.nutribemrefeicoescoletivas.dao.ArquivoDao;
import java.sql.SQLException;

public class ArquivoController {
    
    public boolean salvar( Object obj ) throws SQLException{
        if(new ArquivoDao().cadastrar(obj)){
            System.out.println("Chegou Arquivo");
            return true;
        }else{
            return false;
        }
    }
}
