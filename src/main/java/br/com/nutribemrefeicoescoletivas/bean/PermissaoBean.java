package br.com.nutribemrefeicoescoletivas.bean;


public class PermissaoBean {
    private int ID, IDUsuario, Ferias, Demissao, Promocao, Admissao;

    public PermissaoBean() {
    }

    public PermissaoBean(int ID, int IDUsuario, int Ferias, int Demissao, int Promocao, int Admissao) {
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

    public int getFerias() {
        return Ferias;
    }

    public void setFerias(int Ferias) {
        this.Ferias = Ferias;
    }

    public int getDemissao() {
        return Demissao;
    }

    public void setDemissao(int Demissao) {
        this.Demissao = Demissao;
    }

    public int getPromocao() {
        return Promocao;
    }

    public void setPromocao(int Promocao) {
        this.Promocao = Promocao;
    }

    public int getAdmissao() {
        return Admissao;
    }

    public void setAdmissao(int Admissao) {
        this.Admissao = Admissao;
    }
    
}