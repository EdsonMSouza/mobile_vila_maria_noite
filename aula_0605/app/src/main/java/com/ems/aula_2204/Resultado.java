package com.ems.aula_2204;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {
    TextView ra, nome, curso, raOld, nomeOld, cursoOld;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        raOld = findViewById(R.id.textViewRaOld);
        nomeOld = findViewById(R.id.textViewNomeOld);
        cursoOld = findViewById(R.id.textViewCursoOld);

        ra = findViewById(R.id.textViewRa);
        nome = findViewById(R.id.textViewNome);
        curso = findViewById(R.id.textViewCurso);

        btVoltar = findViewById(R.id.btVoltar);

        // Recuperando os dados da Intent
        ArrayList<Aluno> aluno = (ArrayList<Aluno>)
                getIntent().getSerializableExtra("objAluno");

        // Estudem esse trecho do código para discutirmo na próxima aula
        // Lembrem-se das aulas de array ou vetor (índices)
        raOld.setText(aluno.get(0).getRa());
        nomeOld.setText(aluno.get(0).getNome());
        cursoOld.setText(aluno.get(0).getCurso());

        ra.setText(aluno.get(1).getRa());
        nome.setText(aluno.get(1).getNome());
        curso.setText(aluno.get(1).getCurso());

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
