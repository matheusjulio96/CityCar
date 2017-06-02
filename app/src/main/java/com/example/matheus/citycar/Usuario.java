package com.example.matheus.citycar;

import java.io.Serializable;

/**
 * Created by Nelson Souza on 10/05/2017.
 */

public class Usuario implements Serializable{
    private int cpf;
    private String nome;
    private String telefone;
    private String setor;
    private String senha;

    public Usuario(int cpf,String nome,String telefone,String setor, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.setor = setor;
        this.telefone = telefone;
        this.senha = senha;
    }
    public Usuario(){}

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
