package com.ems.aula_0804;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // declarar variáveis para usar na ligação com
    // os objetos da View (activity_main)
    EditText nome, sobrenome;
    Button btConcatenar;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ligando os objetos da View com as variáveis
        // locais, declaradas acima (linhas 12 a 14)
        nome = findViewById(R.id.editTextNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        btConcatenar = findViewById(R.id.buttonConcatenar);
        resultado = findViewById(R.id.textViewResultado);

        // configurar o evento CLICK do botão para realizar a concatenação
        btConcatenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(nome.getText() + " " + sobrenome.getText());

                // limpa aos campos após realizar a concatenação
                nome.setText("");
                sobrenome.setText("");

                // posiciona o cursor em um campo específico
                nome.requestFocus();
            }
        });

        // .setText() atribui |  .getText() recupera
        //nome.setText("Edson");
        //sobrenome.setText("Melo");
        //resultado.setText("Olá Mundo!!!");

    }
}
