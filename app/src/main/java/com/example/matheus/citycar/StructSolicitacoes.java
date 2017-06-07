package com.example.matheus.citycar;

/**
 * Created by matheus on 07/06/17.
 */

public class StructSolicitacoes {
    public int[] rowid;
    public String[] descricao;

    public StructSolicitacoes(int Tam) {
        this.rowid = new int[Tam];
        this.descricao = new String[Tam];
    }
}
