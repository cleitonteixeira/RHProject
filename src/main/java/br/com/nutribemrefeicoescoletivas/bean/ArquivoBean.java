package br.com.nutribemrefeicoescoletivas.bean;

import java.sql.Date;

/**
 *
 * @author Cleiton
 */
public class ArquivoBean {
    
    private int ID, IDUser;
    private String Nome, Caminho, NomeUser;
    private Date Data;
    private int Tamanho;

    public ArquivoBean() {
    }

    public ArquivoBean(int ID, int IDUser, String Nome, String Caminho, String NomeUser, Date Data, int Tamanho) {
        this.ID = ID;
        this.IDUser = IDUser;
        this.Nome = Nome;
        this.Caminho = Caminho;
        this.NomeUser = NomeUser;
        this.Data = Data;
        this.Tamanho = Tamanho;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCaminho() {
        return Caminho;
    }

    public void setCaminho(String Caminho) {
        this.Caminho = Caminho;
    }

    public String getNomeUser() {
        return NomeUser;
    }

    public void setNomeUser(String NomeUser) {
        this.NomeUser = NomeUser;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public int getTamanho() {
        return Tamanho;
    }

    public void setTamanho(int Tamanho) {
        this.Tamanho = Tamanho;
    }

}
