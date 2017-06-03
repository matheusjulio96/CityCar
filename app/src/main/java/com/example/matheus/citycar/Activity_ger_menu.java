package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_ger_menu extends AppCompatActivity {

    private ListView opcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_menu);

        String[] itens = {
                "Cadastrar Veiculo",
                "Obter Info. Veiculo",
                "Cadastrar Usuario",
                "Aprovar Solicitações"};

        opcoes = (ListView) findViewById(R.id.opcoes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, itens);
        opcoes.setAdapter(adaptador);

        Intent intent = getIntent();
        final Usuario usuarioLogado = (Usuario) intent.getSerializableExtra("usuario");

        TextView txtUsuario = (TextView) findViewById(R.id.lblUsuario);
        txtUsuario.setText(usuarioLogado.getNome());

        final Class[] telas = {
                Activity_ger_cad_veiculo.class,
                Activity_ger_obt_info_veiculo.class,
                Activity_ger_cad_usuario.class,
                Activity_ger_AprovaSolicitacao.class};

        opcoes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Activity_ger_menu.this, telas[position]); //intent para verificar se há recursos no aparelho
                        intent.putExtra("usuario", usuarioLogado);
                        startActivity(intent);
                    }
                }
        );
    }
}
