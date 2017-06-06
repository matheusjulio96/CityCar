package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_ger_DetalheSolicitacao extends AppCompatActivity {

    private AprovaSolicitacao solicitante; // vai para veiculo
    private AprovaSolicitacao solicitacao; // retorna após escolher veiculo
    TextView campo1;
    TextView campo2;
    TextView campo3;
    TextView campo4;
    TextView campo5;
    TextView campo6;
    TextView campo7;
    TextView campo8;
    TextView campo9;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger__detalhe_solicitacao);
        setTitle("CityCar - Detalhe da Solicitação");

        // irá receber a classe que veio por paramentro..
        Intent intent = getIntent();
        solicitante = (AprovaSolicitacao) intent.getSerializableExtra("usuario");

        campo1 = (TextView) findViewById(R.id.txtDetalheNome);
        campo2 = (TextView) findViewById(R.id.txtDetalheSetor);
        campo3 = (TextView) findViewById(R.id.txtDetalheMotivo);
        campo4 = (TextView) findViewById(R.id.txtDetalhePeriodo);
        campo5 = (TextView) findViewById(R.id.txtDetalheHoraInicio);
        campo6 = (TextView) findViewById(R.id.txtDetalhePlaca);
        campo6.setText("");
        campo7 = (TextView) findViewById(R.id.txtDetalheModelo);
        campo8 = (TextView) findViewById(R.id.txtDetalheSolicitacaoLocalRetirada);
        campo9 = (TextView) findViewById(R.id.txtDetalheSolicitacaoHoraRetirada);
        campo8.setText("");
        campo9.setText("");

        campo1.setText(solicitante.getNome());
        campo2.setText(solicitante.getSetor());
        campo3.setText(solicitante.getMotivo());
        campo4.setText(solicitante.getPeriodo());
        campo5.setText(solicitante.getHoraIdeal());
    }
    public void listaVeiculoClicked(View view){
        intent = new Intent(Activity_ger_DetalheSolicitacao.this,Activity_Lista_Veiculos_Disponiveis.class);
        intent.putExtra("solicitante",solicitante);
        //startActivity(intent);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 ){
            try{
                solicitacao =(AprovaSolicitacao) data.getSerializableExtra("valueId");
                campo6.setText(solicitacao.getPlaca());
                campo7.setText(solicitacao.getModelo());
            }catch(Exception e){

            }
        }
    }

    public void btnAprovar(View v){
        if (campo6.getText().length()<3){
            Toast.makeText(getBaseContext(),"Necessário Escolher veiculo!",Toast.LENGTH_LONG).show();
        }else{
            AcessoDados conecta = new AcessoDados(this);
            solicitacao.setHoraRetirada(campo9.getText().toString());
            solicitacao.setLocalRetirada(campo8.getText().toString());
            conecta.aprovarSolicitacao(solicitacao, 1);
            limpaCampos();
            Toast.makeText(getBaseContext(),"Aprovado !",Toast.LENGTH_LONG).show();
        }
    }

    public void btnCancelar(View view){

        if (campo6.getText().length()<3){
            Toast.makeText(getBaseContext(),"Necessário Escolher veiculo!",Toast.LENGTH_LONG).show();
        }else{
            AcessoDados conecta = new AcessoDados(this);
            solicitacao.setHoraRetirada(campo9.getText().toString());
            solicitacao.setLocalRetirada(campo8.getText().toString());
            conecta.aprovarSolicitacao(solicitacao, 0);
            limpaCampos();
            Toast.makeText(getBaseContext(),"Reprovado !",Toast.LENGTH_LONG).show();
        }
    }

    private void limpaCampos(){
        campo1.setText("");
        campo2.setText("");
        campo3.setText("");
        campo4.setText("");
        campo5.setText("");
        campo6.setText("");
        campo7.setText("");
        campo8.setText("");
        campo9.setText("");
        solicitacao = null;
        solicitante = null;

    }

}
