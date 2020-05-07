package com.ems.aula_2204;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Editar extends AppCompatActivity {
    EditText ra, nome,  curso;
    Button btSeguinte, btVoltar;
    ArrayList<Aluno> dados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        ra = findViewById(R.id.editarEditTextRa);
        nome = findViewById(R.id.editarEditTextNome);
        curso = findViewById(R.id.editarEditTextCurso);
        btSeguinte = findViewById(R.id.btSeguinte);
        btVoltar = findViewById(R.id.btVoltar);

        // Recuperando os dados da Intent
        Aluno aluno = (Aluno)
                getIntent().getSerializableExtra("objAluno");

        // adicionando os dados anteriores no ArrayList
        dados.add(aluno);

        // Atribuindo o valor do objeto (atributos) aos controles
        ra.setText(aluno.getRa());
        nome.setText(aluno.getNome());
        curso.setText(aluno.getCurso());

        btSeguinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dados.add(new Aluno(
                        ra.getText().toString(),
                        nome.getText().toString(),
                        curso.getText().toString()));

                Intent intent = new Intent(Editar.this, Resultado.class);

                intent.putExtra("objAluno", dados);
                startActivity(intent);

            }
        });


        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
