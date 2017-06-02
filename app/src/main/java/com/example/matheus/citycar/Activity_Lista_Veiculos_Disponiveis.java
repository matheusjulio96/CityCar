package com.example.matheus.citycar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Lista_Veiculos_Disponiveis extends AppCompatActivity {

    private AcessoDados conecta;
    ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    private Adapter adapter;
    ListView lstVeiculos;
    AprovaSolicitacao solicitante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculos_disponiveis);
        setTitle("CityCar - Veiculos Disponiveis");
        Intent veiointent = getIntent();
        solicitante = (AprovaSolicitacao) veiointent.getSerializableExtra("solicitante");

        conecta = new AcessoDados(this);
        carregaDados();

    }

    public void carregaDados(){
        conecta.listaVeiculos(listaVeiculos);
        //Toast.makeText(getBaseContext(),"carro = "+ listaVeiculos.get(0).getModelo(),Toast.LENGTH_LONG).show();
        if (listaVeiculos != null){
            adapter = new Adapter_VeiculosDisponiveis(this,listaVeiculos); // uso o modelo de adapter que criei...
            lstVeiculos = (ListView) findViewById(R.id.lstVeiculosDisponiveis);
            lstVeiculos.setAdapter((ListAdapter) adapter);
            lstVeiculos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Veiculo veicsel = (Veiculo) adapter.getItem(position);
                    //Toast.makeText(getBaseContext(),"carro = "+ solicitante.getModelo(),Toast.LENGTH_LONG).show();

                    solicitante.setPlaca(veicsel.getPlaca());
                    solicitante.setModelo(veicsel.getModelo());
                    solicitante.setKm(String.valueOf(veicsel.getKmRodado()));
                    //Intent intent = new Intent(Activity_Lista_Veiculos_Disponiveis,Activity_ger_AprovaSolicitacao.class);
                    // intent.putExtra("usuario", aprovar);
                    // startActivity(intent);



                    Intent intent = new Intent();
                    intent.putExtra("valueId", solicitante); //value should be your string from the edittext
                    setResult(0, intent); //The data you want to send back
                    finish();
                }
            });
        }
    }

}

