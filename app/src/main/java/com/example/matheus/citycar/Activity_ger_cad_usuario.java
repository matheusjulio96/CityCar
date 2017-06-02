package com.example.matheus.citycar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_ger_cad_usuario extends AppCompatActivity {

    private int cpf;
    private TextView campo;
    private TextView campo1;
    private TextView campo2;
    private TextView campo3;
    private TextView campo4;

    private Usuario usuario;
    private AcessoDados conecta;
    // flag para verificar se ja é cadastrado !!!!
    int flag = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ger_cad_usuario);
        setTitle("CityCar - Cadastro de Usuarios");
        conecta = new AcessoDados(this);
        campo = (TextView) findViewById(R.id.txtLCPF);
        campo1 = (TextView) findViewById(R.id.txtNome);
        campo2 = (TextView) findViewById(R.id.txtSetor);
        campo3 = (TextView) findViewById(R.id.txtTelefone);
        campo4 = (TextView) findViewById(R.id.txtSenha);

    }

    public void btnPesquisar(View v){
        carregarUsuario();
    }

    public void limpaCampos(){
        campo.setText("");
        campo1.setText("");
        campo2.setText("");
        campo3.setText("");
        campo4.setText("");
    }

    public void btnGravarUsuario(View v){
        cpf = Integer.parseInt(campo.getText().toString());
        if (cpf == 0){
            Toast mensagem = Toast.makeText(this,
                    "Necessário Digitar um CPF", Toast.LENGTH_SHORT);
            mensagem.show();

        }else{
            if (flag == 0 ){
                usuario = new Usuario();
                usuario.setCpf(cpf);
            }
            usuario.setNome(campo1.getText().toString());
            usuario.setSetor(campo2.getText().toString());
            usuario.setTelefone(campo3.getText().toString());
            usuario.setSenha(campo4.getText().toString());

            conecta.inserirUsuario(usuario);
            Toast mensagem = Toast.makeText(this,
                    "Cadastrado..."+conecta.getNumeroRegistroUsuario(), Toast.LENGTH_SHORT);
            mensagem.show();
            limpaCampos();

        }
    }

    /*public void consultaUsuario(){
        cpf = Integer.parseInt(campo.getText().toString());
        usuario = conecta.consultarUsuario(cpf);
        campo1.setText(usuario.getNome());
        campo2.setText(usuario.getSetor());
        campo3.setText(usuario.getTelefone());
        flag = 1;
    }*/

    public void carregarUsuario(){
        cpf = Integer.parseInt(campo.getText().toString());
        usuario = conecta.consultarUsuario(cpf);

        campo1.setText(usuario.getNome());
        campo2.setText(usuario.getSetor());
        campo3.setText(usuario.getTelefone());
        campo4.setText(usuario.getSenha());
    }
}
