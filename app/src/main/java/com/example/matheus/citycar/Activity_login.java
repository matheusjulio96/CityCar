package com.example.matheus.citycar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_login extends AppCompatActivity {

    EditText editCPF;
    EditText editSenha;
    AcessoDados banco;
    String aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editCPF = (EditText) findViewById(R.id.txtLCPF);
        editSenha = (EditText) findViewById(R.id.txtLSenha);
        banco = new AcessoDados(this);
    }

    public void logarClicked(View v){
        try{
            if(editCPF.getText().toString().length() != 0){
                //Toast.makeText(this, editCPF.getText().toString(), Toast.LENGTH_LONG).show();
                if(!editCPF.getText().equals("777")){
                    int cpf = Integer.parseInt(editCPF.getText().toString());
                    Usuario usuarioLogado = banco.consultarUsuario(cpf);

                    if(usuarioLogado != null && usuarioLogado.getSenha().equals(editSenha.getText().toString())){
                        Intent intent = new Intent(Activity_login.this, MainActivity.class); //intent para verificar se há recursos no aparelho
                        intent.putExtra("usuario", usuarioLogado);
                        startActivity(intent);
                    }
                    else{
                        Toast mensagem = Toast.makeText(this, "Usuário ou senha incorretos.", Toast.LENGTH_LONG);
                        mensagem.show();
                    }
                }else{
                    Intent intent = new Intent(Activity_login.this, Activity_ger_menu.class); //intent para verificar se há recursos no aparelho
                    intent.putExtra("usuario", new Usuario(777,"Administrador","777","pref","none"));
                    startActivity(intent);
                }

            }else{
                Toast mensagem = Toast.makeText(this,
                        "Digite o CPF.", Toast.LENGTH_LONG);
                mensagem.show();


                //PARA TESTES
                Intent intent = new Intent(Activity_login.this, Activity_ger_menu.class); //intent para verificar se há recursos no aparelho
                intent.putExtra("usuario", new Usuario(777,"Administrador","777","pref","none"));
                startActivity(intent);
            }

            //nome, setor, cpf, telefone
        }catch (Exception e){
            Toast mensagem = Toast.makeText(this,
                    e.getMessage(), Toast.LENGTH_LONG);
            mensagem.show();

            /*
            * AlertDialog.Builder mensagem = new AlertDialog.Builder(this);
            mensagem.setTitle("Placar");
            mensagem.setMessage("Você acertou "+ponto+" questões.");
            mensagem.setNegativeButton("OK", null);
            mensagem.show();
            * */
        }
    }
}
