package com.ems.aula_1504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // declarando variáveis para associar com os objetos da View
    EditText nome, sobrenome;
    Button btSeguinte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // associar os objetos com as variáveis
        nome = findViewById(R.id.editTextNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        btSeguinte = findViewById(R.id.buttonSeguinte);

        // configurando a ação de click do botão
        btSeguinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here the magic happens
                String txtNome = nome.getText().toString();
                String txtSobrenome = sobrenome.getText().toString();

                // criar o meu correio
                // Intent(origem, destino)
                Intent correio = new Intent(
                        MainActivity.this, Resultado.class
                );

                // criar o envelope (Bundle)
                Bundle envelope = new Bundle();

                // colocando os dados no envelope
                envelope.putString("nome", txtNome);
                envelope.putString("sobrenome", txtSobrenome);

                // levar para o correio
                correio.putExtras(envelope);

                // aqui o correio entrega a correspondência
                startActivity(correio);


            }
        });
    }
}
