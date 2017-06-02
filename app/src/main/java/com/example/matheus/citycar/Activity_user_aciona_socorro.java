package com.example.matheus.citycar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Activity_user_aciona_socorro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_aciona_socorro);

        setTitle(R.string.txt_acionar_socorro);

        String array_spinner[] = {
                this.getString(R.string.txt_prob_mecanico),
                this.getString(R.string.txt_prob_roubo),
                this.getString(R.string.txt_prob_outro)
        };
        Spinner spnProblema = (Spinner) findViewById(R.id.spinner_Problema);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item, array_spinner);
        spnProblema.setAdapter(adapter);
    }
}
