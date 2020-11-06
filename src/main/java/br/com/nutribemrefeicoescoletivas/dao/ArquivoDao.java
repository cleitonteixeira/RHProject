package br.com.nutribemrefeicoescoletivas.dao;

import br.com.nutribemrefeicoescoletivas.bean.ArquivoBean;
import br.com.nutribemrefeicoescoletivas.connection.Conn;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ArquivoDao extends Conn {
    
    public boolean cadastrar(Object obj) throws SQLException{
        boolean rt = false;
        ArquivoBean ab = (ArquivoBean) obj;
        
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        String dat = formatarDate.format(data);
        con = Conn.getConexao();
        try{
            sql = "INSERT INTO arquivo (Nome, Upload, Tamanho, Usuario_idUsuario) VALUES ( ?, ?, ?, ? );";
            System.out.println(ab.getIDUser());
            stmt = con.prepareStatement( sql );
            stmt.setString(1, ab.getNome() );
            stmt.setDate(2, data );
            stmt.setInt(3, ab.getTamanho() );
            stmt.setInt(4, ab.getIDUser());
            stmt.execute();
            rt = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rt;       
    }
}
