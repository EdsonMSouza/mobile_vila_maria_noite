package com.ems.aula_2204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ra, nome, curso;
    Button btInserir;
    ListView lvAlunos;

    // variável para receber uma lista de alunos (objeto aluno)
    ArrayList<Aluno> alunos = new ArrayList<>();

    // criar uma variável para o adaptador (Adapter)
    ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ra = findViewById(R.id.editTextRa);
        nome = findViewById(R.id.editTextNome);
        curso = findViewById(R.id.editTextCurso);
        btInserir = findViewById(R.id.btInserir);
        lvAlunos = findViewById(R.id.listViewAlunos);

        // configurar o adapter (adaptador)
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                alunos);

        // ligar o adaptador com a lvAlunos (ListView)
        lvAlunos.setAdapter(adapter);

        // configurar o botão inserir
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // vamos alimentar a lista de objetos, além do objeto aluno
                /* este método é utilizado com os gets e sets da classe aluno
                Aluno aluno = new Aluno();
                aluno.setRa(ra.getText().toString());
                aluno.setNome(nome.getText().toString());
                aluno.setCurso(curso.getText().toString());
                alunos.add(aluno);
                */

                alunos.add(
                        new Aluno(
                                ra.getText().toString(),
                                nome.getText().toString(),
                                curso.getText().toString()
                        )
                );

                // avisar o adapter que os dados foram modificados
                // ou seja, a variável "alunos" foi alterada
                adapter.notifyDataSetChanged();
            }
        });

        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno = (Aluno) lvAlunos.getItemAtPosition(position);
                Toast.makeText(
                        MainActivity.this,
                        aluno.getDados(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
