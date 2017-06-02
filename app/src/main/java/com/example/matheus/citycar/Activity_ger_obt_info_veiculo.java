package com.example.matheus.citycar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_ger_obt_info_veiculo extends AppCompatActivity {

    private AcessoDados banco;
    private Veiculo veiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_obt_info_veiculo);
        setTitle("CityCar - Informações do Veiculo");
    }

    public void consultarClicked(View v){
        try{
            banco = new AcessoDados(this);

            veiculo = banco.consultaVeiculo(((EditText) findViewById(R.id.txtPlaca)).getText().toString());

            ((EditText) findViewById(R.id.txtAno)).setText(veiculo.getAno());

            ((EditText) findViewById(R.id.txtModelo)).setText(veiculo.getModelo());

            ((EditText) findViewById(R.id.txtCombustivel)).setText(veiculo.getCombustivel());

            ((EditText) findViewById(R.id.txtChassi)).setText(veiculo.getChassi());

            ((EditText) findViewById(R.id.txtMarca)).setText(veiculo.getMarca());


        }catch (Exception e){
            Toast mensagem = Toast.makeText(this,
                    "Erro ao consultar...", Toast.LENGTH_LONG);
            mensagem.show();
        }
    }


}
