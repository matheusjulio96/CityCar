package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_user_ve_locacoes extends AppCompatActivity {

    private ListView locacoes;

    private AcessoDados banco;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ve_locacoes);

        setTitle(this.getString(R.string.txt_minhas_locacoes));



        banco = new AcessoDados(this);

        Intent intent = getIntent();
        usuarioLogado = (Usuario) intent.getSerializableExtra("usuario");

        //String[] itens = {"Fusca Azul - 03/05/17","Fusca Preto - 04/05/17"};//solicitacoes
        final StructSolicitacoes ss = banco.consultarSolicitacoes(usuarioLogado.getCpf());//solicitacoes
        /*String[] locs = new String[dados.length/3];

        for(int i=0; i<locs.length; i++){
            locs[i] = dados[i*3] + " - " + dados[i*3+1] + " - " + dados[i*3+2];
        }*/

        locacoes = (ListView) findViewById(R.id.locacoes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, ss.descricao);
        locacoes.setAdapter(adaptador);

        locacoes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Activity_user_ve_locacoes.this, Activity_user_ve_solicitacao.class); //intent para verificar se há recursos no aparelho
                        intent.putExtra("numClick", ss.rowid[position]);
                        startActivity(intent);
                    }
                }
        );
    }
}
