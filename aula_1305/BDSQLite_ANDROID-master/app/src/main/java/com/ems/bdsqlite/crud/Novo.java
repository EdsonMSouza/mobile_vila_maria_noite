package com.ems.bdsqlite.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ems.bdsqlite.R;
import com.ems.bdsqlite.utils.Banco;

public class Novo extends AppCompatActivity {
    EditText ra, nome, curso;
    ImageButton btConfirma, btVoltar;

    // Declarar uma variável para receber o acesso ao Banco de Dados
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        // Mostra um botão na Barra Superior para voltar
        getSupportActionBar().setTitle("Incluir Aluno");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ra = findViewById(R.id.editTextRa);
        nome = findViewById(R.id.editTextNome);
        curso = findViewById(R.id.editTextCurso);
        btConfirma = findViewById(R.id.btConfirma);
        btVoltar = findViewById(R.id.btVoltar);

        // Criar as interações com o banco de dados
        // Abertura ou criação do banco (conexão)
        db = openOrCreateDatabase(
                Banco.banco(),
                Context.MODE_PRIVATE,
                null);

        // Verifica se a tabela existe, se não existir, cria
        db.execSQL(Banco.criaTabela());

        btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pegar os dados digitados e gravar no banco (tabela)
                ContentValues dados = new ContentValues();
                // key: o nome da coluna da tabela
                // value: o conteúdo do campo da tabela
                dados.put("ra", ra.getText().toString());
                dados.put("nome", nome.getText().toString());
                dados.put("curso", curso.getText().toString());

                // Insere efetivamente no banco de dados (tabela)
                db.insert(
                        Banco.tabela(), // nome da tabela
                        null, // parâmetro null
                        dados); // os dados coletados

                Toast.makeText(
                        Novo.this,
                        "Registro inserido com sucesso!",
                        Toast.LENGTH_LONG).show();

                finish(); // fecha a View (activity_novo.xml)
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Configura o botão (seta) na ActionBar (Barra Superior)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}