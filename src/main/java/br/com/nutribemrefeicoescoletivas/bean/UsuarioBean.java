package br.com.nutribemrefeicoescoletivas.bean;

public class UsuarioBean {
    private int ID;
    private String Nome, Login, Senha, Email, Ativo;

    public UsuarioBean() {
    }

    public UsuarioBean(int ID, String Nome, String Login, String Senha, String Email, String Ativo) {
        this.ID = ID;
        this.Nome = Nome;
        this.Login = Login;
        this.Senha = Senha;
        this.Email = Email;
        this.Ativo = Ativo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAtivo() {
        return Ativo;
    }

    public void setAtivo(String Ativo) {
        this.Ativo = Ativo;
    }
    
    
}
