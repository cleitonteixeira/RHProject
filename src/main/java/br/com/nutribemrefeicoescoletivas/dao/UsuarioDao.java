package br.com.nutribemrefeicoescoletivas.dao;

import br.com.nutribemrefeicoescoletivas.bean.UsuarioBean;
import br.com.nutribemrefeicoescoletivas.connection.Conn;
import br.com.nutribemrefeicoescoletivas.tools.Criptografia;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDao extends Conn{
    public void cadastra(Object usernc) throws SQLException{
        UsuarioBean user = (UsuarioBean) usernc;
        sql = "INSERT INTO usuario (Nome, Login, Senha) VALUES (?, ?, ?);";
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getSenha());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }
        con.close();
    }
    public void atualiza(Object usernc) throws SQLException{
        UsuarioBean user = (UsuarioBean) usernc;
        sql = "UPDATE Usuario SET Nome = ?, Ativo = ? WHERE idUsuario = ?;";
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getAtivo());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        }
        con.close();
    }
    public boolean logar (Object usernc) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        UsuarioBean user = (UsuarioBean) usernc;
        boolean retorno;
        sql = "SELECT * FROM Usuario WHERE login = ?;";
        System.out.println("SELECT * FROM Usuario WHERE login ="+user.getLogin());
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            res = stmt.executeQuery();
            if(res.next()){
                UsuarioBean usernci = new UsuarioBean();
                usernci.setID(res.getInt("idUsuario"));
                usernci.setNome(res.getString("Nome"));
                if(res.getString("Senha").equals(new Criptografia().criptografa(user.getSenha()))){
                    if(res.getString("Ativo").equals("S")){
                        //JOptionPane.showMessageDialog(null, "Bem Vindo, "+usernci.getNome());
                        retorno = true;
                    }else{
                        retorno = false;
                        JOptionPane.showMessageDialog(null, "Usuário inativo");
                    }
                }else{
                    retorno = false;
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            }else{
                retorno = false;
                JOptionPane.showMessageDialog(null, "Usuário não encontrato.");
            }
        } catch (SQLException e) {
            retorno = false;
        }
        res.close();
        stmt.close();
        con.close();
        return retorno;
    }
    public Object busca (UsuarioBean usernc) throws SQLException{
        UsuarioBean usernci = new UsuarioBean();
        sql = "SELECT * FROM Usuario WHERE Login = ?";
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usernc.getLogin());
            res = stmt.executeQuery();
            if(res.next()){
                usernci.setID(res.getInt("idUsuario"));
                usernci.setNome(res.getString("Nome"));
                usernci.setAtivo(res.getString("Ativo"));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
        res.close();
        stmt.close();
        con.close();
        return usernci;
    }
    public List<UsuarioBean> lista () throws SQLException{
        con = Conn.getConexao();
        sql = "SELECT * FROM Usuario";
        stmt = con.prepareStatement(sql);
        res = stmt.executeQuery();
        List<UsuarioBean> ListaUsuario = new ArrayList <>();
        while(res.next()){
            UsuarioBean fBean = new UsuarioBean();
            fBean.setID(res.getInt("idUsuario"));
            fBean.setNome(res.getString("Nome"));
            ListaUsuario.add(fBean);
        }
        res.close();
        stmt.close();
        con.close();
       return ListaUsuario;
    }
    public List<UsuarioBean> consultaRefinada (String Nome) throws SQLException{
        con = Conn.getConexao();

        sql = "SELECT * FROM Usuario WHERE Nome LIKE ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, '%' + Nome + '%');
        res = stmt.executeQuery();
        List<UsuarioBean> ListaUsuario = new ArrayList <>();
        while(res.next()){
            UsuarioBean fBean = new UsuarioBean();
            fBean.setID(res.getInt("idUsuario"));
            fBean.setNome(res.getString("Nome"));
            ListaUsuario.add(fBean);
        }
        res.close();
        stmt.close();
        con.close();
        return ListaUsuario;
    }
    public int ReturnId() throws SQLException{
        sql = "SELECT MAX(idUsuario) FROM Usuario";
        try {
            con =  Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        stmt = con.prepareStatement(sql);
        res = stmt.executeQuery();
        int cod = 0;
        if(res.next()){
            cod = res.getInt("MAX(idUsuario)");
        }
        res.close();
        stmt.close();        
        con.close();
        return cod;
        
    }
}
