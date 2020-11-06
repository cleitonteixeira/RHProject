package br.com.nutribemrefeicoescoletivas.control;

import br.com.nutribemrefeicoescoletivas.bean.FuncionarioBean;
import br.com.nutribemrefeicoescoletivas.dao.FuncionarioDao;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    public boolean cadastro(Object obj) throws SQLException{
        if(!new FuncionarioDao().Consulta(obj)){
            if(new FuncionarioDao().Cadastrar(obj)){
                return true;
            }else{
                return false;
            }
        }else{
            if(new FuncionarioDao().Atualizar(obj)){
                return true;
            }else{
                return false;
            }
        }
    }
    public List<FuncionarioBean> buscar() throws SQLException{
        return new FuncionarioDao().Busca();
    }
}
