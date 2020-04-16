package com.ems.aula_1504;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    TextView nome, sobrenome;
    Button btVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nome = findViewById(R.id.textViewNome);
        sobrenome = findViewById(R.id.textViewSobrenome);
        btVoltar = findViewById(R.id.buttonVoltar);

        // receber o correio
        Intent correio = getIntent();

        // Pego o envelope do correio
        Bundle envelope = correio.getExtras();

        // abrir o envelope e pegar os dados e também mostrar na tela
        nome.setText(envelope.getString("nome"));
        sobrenome.setText(envelope.getString("sobrenome"));

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // fecha a Intent atual
            }
        });
    }
}