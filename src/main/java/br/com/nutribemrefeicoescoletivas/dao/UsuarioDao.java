package br.com.nutribemrefeicoescoletivas.dao;

import br.com.nutribemrefeicoescoletivas.bean.PermissaoBean;
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
    public boolean salvar(Object usernc) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        UsuarioBean user = (UsuarioBean) usernc;
        boolean rt = false;
        sql = "INSERT INTO usuario (Nome, Email, Login, Senha) VALUES ( ?, ?, ?, ?);";
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, new Criptografia().criptografa(user.getSenha()));
            stmt.execute();
            rt = true;
            //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }catch(SQLException e){
            e.printStackTrace();
            rt = false;
            //JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }finally{
            stmt.close();
            con.close();
        }
        return rt;
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
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
    }
    public boolean logar (Object usernc) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        UsuarioBean user = (UsuarioBean) usernc;
        boolean retorno;
        sql = "SELECT * FROM Usuario WHERE login = ?;";
        System.out.println("SELECT * FROM Usuario WHERE login = "+user.getLogin());
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
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
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
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
        return usernci;
    }
    public List<UsuarioBean> lista () throws SQLException{
        List<UsuarioBean> ListaUsuario = new ArrayList <>();
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            sql = "SELECT * FROM Usuario";
            stmt = con.prepareStatement(sql);
            res = stmt.executeQuery();
            while(res.next()){
                UsuarioBean fBean = new UsuarioBean();
                fBean.setID(res.getInt("idUsuario"));
                fBean.setNome(res.getString("Nome"));
                ListaUsuario.add(fBean);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
       return ListaUsuario;
    }
    public List<UsuarioBean> consultaRefinada (String Nome) throws SQLException{
        List<UsuarioBean> ListaUsuario = new ArrayList <>();

        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try {
            sql = "SELECT * FROM Usuario WHERE Nome LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, '%' + Nome + '%');
            res = stmt.executeQuery();
            while(res.next()){
                UsuarioBean fBean = new UsuarioBean();
                fBean.setID(res.getInt("idUsuario"));
                fBean.setNome(res.getString("Nome"));
                ListaUsuario.add(fBean);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
        return ListaUsuario;
    }
    public int ReturnId() throws SQLException{
        int cod = 0;
        try {
            con =  Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            sql = "SELECT MAX(idUsuario) AS idUsuario FROM Usuario";
            stmt = con.prepareStatement(sql);
            res = stmt.executeQuery();
            if(res.next()){
                cod = res.getInt("idUsuario");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
        return cod;
    }
    public boolean CadastraPermissao(Object obj) throws SQLException{
        boolean rt = false;
        PermissaoBean per = (PermissaoBean) obj;
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try {
            sql = "INSERT INTO permissao (Usuario_idUsuario, Ferias, Demissao, Promocao, Admissao) VALUES ( ?, ?, ?, ?, ? )";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, per.getIDUsuario());
            stmt.setString(2, per.getFerias());
            stmt.setString(3, per.getDemissao());
            stmt.setString(4, per.getPromocao());
            stmt.setString(5, per.getAdmissao());
            stmt.execute();
            rt = true;
        } catch (Exception e) {
            rt = false;
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            stmt.close();
            con.close();
        }
        return rt;
    }
    public Object BuscaPermissao(Object user) throws SQLException {
        UsuarioBean uPer = (UsuarioBean) user;
        PermissaoBean per = new PermissaoBean();
        sql = "SELECT * FROM permissao WHERE Usuario_idUsuario = ?";
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, uPer.getID());
            res = stmt.executeQuery();
            if(res.next()){
                per.setFerias(res.getString("Ferias"));
                per.setAdmissao(res.getString("Admissao"));
                per.setDemissao(res.getString("Demissao"));
                per.setPromocao(res.getString("Promocao"));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            res.close();
            stmt.close();
            con.close();
        }
        return per;
    }
}
