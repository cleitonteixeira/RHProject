package br.com.nutribemrefeicoescoletivas.bean;


public class PermissaoBean {
    private int ID, IDUsuario;
    private String Ferias, Demissao, Promocao, Admissao;

    public PermissaoBean() {
    }

    public PermissaoBean(int ID, int IDUsuario, String Ferias, String Demissao, String Promocao, String Admissao) {
        this.ID = ID;
        this.IDUsuario = IDUsuario;
        this.Ferias = Ferias;
        this.Demissao = Demissao;
        this.Promocao = Promocao;
        this.Admissao = Admissao;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getFerias() {
        return Ferias;
    }

    public void setFerias(String Ferias) {
        this.Ferias = Ferias;
    }

    public String getDemissao() {
        return Demissao;
    }

    public void setDemissao(String Demissao) {
        this.Demissao = Demissao;
    }

    public String getPromocao() {
        return Promocao;
    }

    public void setPromocao(String Promocao) {
        this.Promocao = Promocao;
    }

    public String getAdmissao() {
        return Admissao;
    }

    public void setAdmissao(String Admissao) {
        this.Admissao = Admissao;
    }
    
}