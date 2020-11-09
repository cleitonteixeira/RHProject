package br.com.nutribemrefeicoescoletivas.control;

import br.com.nutribemrefeicoescoletivas.bean.UsuarioBean;
import br.com.nutribemrefeicoescoletivas.dao.UsuarioDao;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UsuarioController {
    public boolean entrar(Object user) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        return new UsuarioDao().logar(user);
    }
    public UsuarioBean consultar(UsuarioBean user) throws SQLException{
        return (UsuarioBean) new UsuarioDao().busca(user);
    }
    public Object busca(Object use) throws SQLException{
        UsuarioBean user = (UsuarioBean) use;
        return new UsuarioDao().busca(user);
    }
    public boolean cadastrar(Object use) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        return new UsuarioDao().salvar(use);
    }
}
