package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView opcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] itens = {this.getString(R.string.txt_solicitar_veiculo),
                this.getString(R.string.txt_minhas_locacoes),
                this.getString(R.string.txt_acionar_socorro)};

        opcoes = (ListView) findViewById(R.id.opcoes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, itens);
        opcoes.setAdapter(adaptador);

        Intent intent = getIntent();
        final Usuario usuarioLogado = (Usuario) intent.getSerializableExtra("usuario");

        TextView txtUsuario = (TextView) findViewById(R.id.lblUsuario);
        txtUsuario.setText(usuarioLogado.getNome());

        final Class[] telas = {
                Activity_user_solicita_veiculo.class,
                Activity_user_ve_locacoes.class,
                Activity_user_aciona_socorro.class};

        opcoes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, telas[position]); //intent para verificar se há recursos no aparelho
                        intent.putExtra("usuario", usuarioLogado);
                        startActivity(intent);
                    }
                }
        );
    }
}
