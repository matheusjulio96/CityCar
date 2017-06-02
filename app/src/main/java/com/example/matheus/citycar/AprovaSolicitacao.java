package com.example.matheus.citycar;

/**
 * Created by matheus on 02/06/17.
 */


import java.io.Serializable;

/**
 * Created by Nelson Souza on 28/05/2017.
 */



public class AprovaSolicitacao implements Serializable{
    private String nome;
    private String cpf;
    private String motivo;
    private boolean deferido;
    private String placa;
    private String km;
    private String modelo;
    private String horaRetirada;
    private String localRetirada;
    private String idRegistro;
    private String setor;
    private String horaIdeal;
    private String periodo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isDeferido() {
        return deferido;
    }

    public void setDeferido(boolean deferido) {
        this.deferido = deferido;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getHoraIdeal() {
        return horaIdeal;
    }

    public void setHoraIdeal(String horaIdeal) {
        this.horaIdeal = horaIdeal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}

