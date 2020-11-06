package br.com.nutribemrefeicoescoletivas.bean;

import java.sql.Date;

public class FuncionarioBean {
    private int ID, IDUnidade, IDCadastro, Situacao;
    private Long CPF;
    private Date DContrato;
    private String Nome, Cargo, Unidade;
    private Double Salario;

    public FuncionarioBean() {
    }

    public FuncionarioBean(int ID, int IDUnidade, int IDCadastro, int Situacao, Long CPF, Date DContrato, String Nome, String Cargo, String Unidade, Double Salario) {
        this.ID = ID;
        this.IDUnidade = IDUnidade;
        this.IDCadastro = IDCadastro;
        this.Situacao = Situacao;
        this.CPF = CPF;
        this.DContrato = DContrato;
        this.Nome = Nome;
        this.Cargo = Cargo;
        this.Unidade = Unidade;
        this.Salario = Salario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDUnidade() {
        return IDUnidade;
    }

    public void setIDUnidade(int IDUnidade) {
        this.IDUnidade = IDUnidade;
    }

    public int getIDCadastro() {
        return IDCadastro;
    }

    public void setIDCadastro(int IDCadastro) {
        this.IDCadastro = IDCadastro;
    }

    public int getSituacao() {
        return Situacao;
    }

    public void setSituacao(int Situacao) {
        this.Situacao = Situacao;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public Date getDContrato() {
        return DContrato;
    }

    public void setDContrato(Date DContrato) {
        this.DContrato = DContrato;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }
    
}
