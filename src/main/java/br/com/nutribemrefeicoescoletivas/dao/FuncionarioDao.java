package br.com.nutribemrefeicoescoletivas.dao;

import br.com.nutribemrefeicoescoletivas.bean.FuncionarioBean;
import br.com.nutribemrefeicoescoletivas.connection.Conn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FuncionarioDao extends Conn{
    public boolean Cadastrar(Object funcnc) throws SQLException{
        boolean ret = false;
        FuncionarioBean func = (FuncionarioBean) funcnc;       
        
        sql = "INSERT INTO colaborador ( Unidade_idUnidade, Nome, CPF, Situacao, DContratacao, Cargo, Salario ) VALUES( ?, ?, ?, ?, ?, ?, ? );";
        
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, func.getIDUnidade());
            stmt.setString(2, func.getNome());
            stmt.setLong(3, func.getCPF());
            stmt.setInt(4, func.getSituacao());
            stmt.setDate(5, func.getDContrato());
            stmt.setString(6, func.getCargo());
            stmt.setDouble(7, func.getSalario());
            stmt.execute();
            //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            ret = true;
        }catch(SQLException e){
            ret = false;
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }finally{
            stmt.close();
            con.close();
        }
        return ret;
    }
    public boolean Atualizar(Object obj) throws SQLException{
        FuncionarioBean fb = (FuncionarioBean) obj;
        boolean ret = false;
        sql = "UPDATE colaborador SET Salario = ?, Cargo = ?, Situacao = ?, Unidade_idUnidade = ? WHERE Nome = ? AND CPF = ? AND DContratacao = ?";
        try {
            con = Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        //System.out.println("ID UNIDADE:"+func.getIDUnidade());
        try{
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, fb.getSalario());
            stmt.setString(2, fb.getCargo());
            stmt.setInt(3, fb.getSituacao());
            stmt.setInt(4, fb.getIDUnidade());
            stmt.setString(5, fb.getNome());
            stmt.setLong(6, fb.getCPF());
            stmt.setDate(7, fb.getDContrato());
            
            stmt.execute();
            //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            ret = true;
        }catch(SQLException e){
            ret = false;
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }finally{
            stmt.close();
            con.close();
        }
        return ret;
    }
    public int ReturnID() throws SQLException{
        sql = "SELECT MAX(idCadastro) as idCadastro FROM cadastro;";
        try {
            con =  Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        stmt = con.prepareStatement(sql);
        res = stmt.executeQuery();
        int cod = 0;
        if(res.next()){
            cod = res.getInt("idCadastro");
        }
        res.close();
        stmt.close();        
        con.close();
        return cod;
    }
    
    public List<FuncionarioBean> Busca() throws SQLException{
        List<FuncionarioBean> lFuncionario = new ArrayList<>();
        sql = "SELECT c.*, u.Nome AS Unidade FROM colaborador c INNER JOIN unidade u ON u.idUnidade = c.Unidade_idUnidade WHERE c.Situacao <> 8";
        try {
            con =  Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            stmt = con.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()){
                FuncionarioBean fun = new FuncionarioBean();
                fun.setCPF(res.getLong("CPF"));
                fun.setNome(res.getString("Nome"));
                fun.setDContrato(res.getDate("DContratacao"));
                fun.setCargo(res.getString("Cargo"));
                fun.setUnidade(res.getString("Unidade"));
                lFuncionario.add(fun);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            stmt.close();
            res.close();
            con.close();
        }
        
        return lFuncionario;
    }
    public boolean Consulta(Object obj) throws SQLException{
        FuncionarioBean fb = (FuncionarioBean) obj;
        boolean rt = false;
        sql = "SELECT * FROM colaborador WHERE DContratacao = ? AND CPF = ? AND Nome = ? ";
        try {
            con =  Conn.getConexao();
        }catch(SQLException xp){
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, xp);
        }
        try{
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, fb.getDContrato());
            stmt.setLong(2, fb.getCPF());
            stmt.setString(3, fb.getNome());
            res = stmt.executeQuery();
            if(res.next()){
                rt = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            stmt.close();
            res.close();
            con.close();
        }
        return rt;
    }
    
    
}
