package com.ems.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView loginResultado;
    String jsonInputString = null;

    // Inner Class (Nested Class) - É uma classe dentro de outra classe
    // Nested significa "aninhada"
    // <> significa diamond
    public class UserService extends AsyncTask<Void, Void, List<User>> {
        // construtor
        public UserService(User user) {
            // cria uma instância para o objeto GSON
            Gson gson = new Gson();
            jsonInputString = gson.toJson(user);
        }

        // implementar o método doInBackground, que executa ações em
        // segundo plano
        protected List<User> doInBackground(Void... voids) {
            // variável para receber o retorno do servidor
            // recebe mais de um valor, ou seja, recebe linhas
            final StringBuilder response = new StringBuilder();

            try {
                // instanciar os objetos para se conectar na internet
                // na variável "url" informamos nosso EndPoint
                URL url = new URL("http://emsapi.esy.es/api_android/user.php");
                // abrir (open) a conexão com o servidor (HTTP ou HTTPS)
                HttpURLConnection serv = (HttpURLConnection) url.openConnection();
                // configurar a requisição (serv)
                serv.setRequestMethod("POST");
                serv.setRequestProperty("Content-Type", "application/json; utf-8");
                serv.setRequestProperty("Accept", "application/json");
                serv.setConnectTimeout(5000); // 5 segundos (tempo da conexão)
                serv.setReadTimeout(5000); // 5 segundos (tempo da resposta)
                serv.setDoInput(true); // permite que os dados sejam retornados (Pull)
                serv.setDoOutput(true); // permite que seja realizada um requisição (Push)

                // aqui vamos fazer a conexão (Request) com o servidor
                try (OutputStream os = serv.getOutputStream()) {
                    // converter os dados em bytes
                    byte[] input = jsonInputString.getBytes("utf-8");
                    // agora é hora de enviar de "fato" ao servidor
                    os.write(input, 0, input.length);
                }

                // vamos pegar a resposta do servidor (response)
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(serv.getInputStream(), "utf-8"))) {

                    // variável para receber os dados (linhas) enviadas pelo servidor
                    String responseLine = null;

                    // percorrer as linhas enviadas, caso existam!!!!!
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    // vamos mostrar no logcat os valores retornados
                    System.out.println("Resposta: " + response.toString());
                }

            } catch (IOException io) {
                System.out.println(io.getMessage());
            }

            // cria uma lista para retornar o objeto associado (User)
            Type userType = new TypeToken<ArrayList<User>>() {
            }.getType();

            // criar outra lista para colocar os objetos decodificados
            List<User> dados = new Gson().fromJson(response.toString(), userType);

            return dados;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginResultado = findViewById(R.id.loginResultado);

        User user = new User();
        user.setType("login");
        user.setName("Zé Carioca");
        user.setUser("Ilvan.Ghosh");
        user.setPassword("ilvan123");

        try {
            ArrayList<User> usuario = (ArrayList<User>) new UserService(user).execute().get();
            // quando tiver mais de um objeto na lista
            //for (User x: usuario) {
            //    System.out.println(x.getName());
            //}

            loginResultado.setText(usuario.get(0).getName());

        } catch (ExecutionException e) {
        } catch (InterruptedException i) {
        }
    }
}