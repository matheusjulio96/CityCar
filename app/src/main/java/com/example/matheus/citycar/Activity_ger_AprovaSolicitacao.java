package com.example.matheus.citycar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_ger_AprovaSolicitacao extends AppCompatActivity {
    Cursor cursor;
    ListView lstDados;
    private Adapter adapter;
    AcessoDados conecta ;
    ArrayList<AprovaSolicitacao>listaSolicitacoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_aprova_solicitacao);
        setTitle("CityCar - Solicitações Pendentes");

        conecta = new AcessoDados(this);
        ArrayList<AprovaSolicitacao>listaSolicitacoes;
        carregaDados();

    }

    public void carregaDados(){
        conecta.listaSolicitacoes(listaSolicitacoes);
        if (listaSolicitacoes != null){
            adapter = new Adapter_AprovaSolicitacao(this,listaSolicitacoes); // uso o modelo de adapter que criei...
            lstDados = (ListView) findViewById(R.id.lstDados);
            lstDados.setAdapter((ListAdapter) adapter);

            lstDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    /*AprovaSolicitacao aprovar = (AprovaSolicitacao) adapter.getItem(position);
                    Toast.makeText(getBaseContext(),"Rsetor.  = "+ aprovar.getSetor(),Toast.LENGTH_LONG).show(); */

                    AprovaSolicitacao aprovar = (AprovaSolicitacao) adapter.getItem(position);
                    Intent intent = new Intent(Activity_ger_AprovaSolicitacao.this,Activity_ger_DetalheSolicitacao.class);
                    intent.putExtra("usuario", aprovar);
                    startActivity(intent);

                }
            });

        }

    }

}
