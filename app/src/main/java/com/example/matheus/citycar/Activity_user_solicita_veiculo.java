package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_user_solicita_veiculo extends AppCompatActivity {

    private String array_spinner[];
    private AcessoDados banco;
    private Usuario usuarioLogado;
    private Solicitacao so;

    private EditText txtMotivo;
    private Spinner spinPeriodo;
    private RadioButton radioDias;
    private RadioButton radioHoras;
    private EditText txtHoraIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_solicita_veiculo);

        setTitle(R.string.txt_solicitacao_veiculo);

        banco = new AcessoDados(this);

        array_spinner = new String[8];
        array_spinner[0] = "1";
        array_spinner[1] = "2";
        array_spinner[2] = "3";
        array_spinner[3] = "4";
        array_spinner[4] = "5";
        array_spinner[5] = "6";
        array_spinner[6] = "7";
        array_spinner[7] = "8";

        Spinner spnPeriodo = (Spinner) findViewById(R.id.spinner_Periodo);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item, array_spinner);
        spnPeriodo.setAdapter(adapter);

        Intent intent = getIntent();
        usuarioLogado = (Usuario) intent.getSerializableExtra("usuario");

        txtMotivo = (EditText)findViewById(R.id.txt_Motivo);
        spinPeriodo = spnPeriodo;
        radioDias = (RadioButton)findViewById(R.id.rbtn_Dias);
        radioDias.setChecked(true);
        radioHoras = (RadioButton)findViewById(R.id.rbtn_Horas);
        txtHoraIdeal = (EditText)findViewById(R.id.txt_Hora_Inicio);

        ((EditText)findViewById(R.id.txt_Nome)).setText(usuarioLogado.getNome());
        ((EditText)findViewById(R.id.txt_Departamento)).setText(usuarioLogado.getSetor());
    }

    public void enviarClicked(View v){
        try{
            so = new Solicitacao(
                    usuarioLogado.getCpf(),
                    txtMotivo.getText().toString(),
                    Integer.parseInt(spinPeriodo.getSelectedItem().toString()),
                    radioDias.isChecked(),
                    radioHoras.isChecked(),
                    txtHoraIdeal.getText().toString()
            );
            so.setDeferido(false);

            banco.insertSolicitacao(so);

            Toast mensagem = Toast.makeText(this,
                    "Cadastrado..."+banco.getNumeroRegistroSolicitacao(), Toast.LENGTH_SHORT);
            mensagem.show();
        }catch (Exception e){
            Toast mensagem = Toast.makeText(this,
                    e.getMessage(), Toast.LENGTH_LONG);
            mensagem.show();
        }
    }

    public void pesquisarClicked(View v){
        try{
            int rowid = Integer.parseInt(txtMotivo.getText().toString());
            so = banco.consultarSolicitacao(rowid);

            txtMotivo.setText(so.getMotivo());
            //campo2.setText(usuario.getSetor());
            radioDias.setChecked(so.isDias());
            radioHoras.setChecked(so.isHoras());
            txtHoraIdeal.setText(so.getHoraIdeal());
        }catch (Exception e){
            Toast mensagem = Toast.makeText(this,
                    e.getMessage(), Toast.LENGTH_LONG);
            mensagem.show();
        }
    }

    public void limpaCampos(){
        txtMotivo.setText("");
        spinPeriodo.setSelection(0);
        radioDias.setChecked(true);
        radioHoras.setChecked(false);
        txtHoraIdeal.setText("");
    }
}
