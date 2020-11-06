package br.com.nutribemrefeicoescoletivas.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conn {
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet res;
    protected String sql;
    public static Connection getConexao() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/rhnutribem?autoReconnect=true&useSSL=true&useTimezone=true&serverTimezone=UTC", "root", "35616110");
    }
}