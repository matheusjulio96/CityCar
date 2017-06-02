package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Activity_user_ve_solicitacao extends AppCompatActivity {

    private AcessoDados banco;
    private Solicitacao solicitacao;

    EditText txtMotivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ve_solicitacao);

        setTitle(this.getString(R.string.txt_minha_solic));

        Intent intent = getIntent();
        int num = (int) intent.getSerializableExtra("numClick");

        banco = new AcessoDados(this);
        int rowid = banco.getNumeroRegistroSolicitacao()-num;

        solicitacao = banco.consultarSolicitacao(rowid);

        txtMotivo = (EditText)findViewById(R.id.txtMotivo);
        txtMotivo.setText(solicitacao.getMotivo());
    }
}
