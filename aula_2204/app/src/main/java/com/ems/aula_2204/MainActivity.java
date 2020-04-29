package com.ems.aula_2204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText ra, nome, curso;
    Button btInserir;
    ListView lvAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ra = findViewById(R.id.editTextRa);
        nome = findViewById(R.id.editTextNome);
        curso = findViewById(R.id.editTextCurso);
        btInserir = findViewById(R.id.btInserir);
        lvAlunos = findViewById(R.id.listViewAlunos);

        // configurar o botão inserir
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
