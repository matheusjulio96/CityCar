package com.example.matheus.citycar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_ger_cad_veiculo extends AppCompatActivity {

    private AcessoDados banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_cad_veiculo);
        banco = new AcessoDados(this);

        txtMarca=(EditText)findViewById(R.id.txtMarca);
        txtModelo=(EditText)findViewById(R.id.txtModelo);
        txtAno=(EditText)findViewById(R.id.txtAno);
        txtCombustivel=(EditText)findViewById(R.id.txtCombustivel);
        txtChassi=(EditText)findViewById(R.id.txtChassi);
        txtPlaca=(EditText)findViewById(R.id.txtPlaca);
        txtKmRodado=(EditText)findViewById(R.id.txtKmRodado);
    }

    EditText txtMarca;
    EditText txtModelo;
    EditText txtAno;
    EditText txtCombustivel;
    EditText txtChassi;
    EditText txtPlaca;
    EditText txtKmRodado;

    public void cadastrarClicked(View v){
        try{
            Veiculo ve = new Veiculo(
                    txtMarca.getText().toString(),
                    txtModelo.getText().toString(),
                    txtAno.getText().toString(),
                    txtCombustivel.getText().toString(),
                    txtChassi.getText().toString(),
                    txtPlaca.getText().toString());
            ve.setKmRodado(Integer.parseInt(txtKmRodado.getText().toString()));

            banco.insertVeiculo(ve);
            limpaCampos();

            Toast mensagem = Toast.makeText(this,
                    "Cadastrado..."+banco.getNumeroRegistroVeiculo(), Toast.LENGTH_SHORT);
            mensagem.show();
        }catch (Exception e){
            Toast mensagem = Toast.makeText(this,
                    "Erro ao cadastrar...", Toast.LENGTH_LONG);
            mensagem.show();
        }
    }

    public void limpaCampos(){
        txtAno.setText("");
        txtChassi.setText("");
        txtCombustivel.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtPlaca.setText("");
        txtKmRodado.setText("");
    }
}
