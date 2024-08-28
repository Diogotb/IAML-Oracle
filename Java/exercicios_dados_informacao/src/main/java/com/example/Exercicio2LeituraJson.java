package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import netscape.javascript.JSObject;

public class Exercicio2LeituraJson {
    String apiUrl = "http://localhost:3000/usuarios";

    public void app(){
        try {
            // Conecta-se à API
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // código 200 OK
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                 // Lê a resposta da API linha por linha
                 while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Processar os dados do JSON
                JSONArray usuarios = new JSONArray(content.toString());

                List<Usuario> dadosUsuarios = new ArrayList<>();
                int somaIdades = 0;

                System.out.println("Dados dos Usuários:");

                for (int i = 0; i < usuarios.length(); i++) {
                    JSONObject usuario = usuarios.getJSONObject(i);
                    dadosUsuarios.add(new Usuario(
                        usuario.getInt("id"), 
                        usuario.getString("nome"), 
                        usuario.getInt("idade"), 
                        usuario.getString("cidade")
                    ));

                    somaIdades += usuario.getInt("idade");

                    System.out.println(
                    "ID: " + usuario.getInt("id") + 
                    " Nome: " + usuario.getString("nome") + 
                    " Idade: " + usuario.getInt("idade") +
                    " Cidade: " + usuario.getString("cidade"));
                }

                int totalUsuarios = dadosUsuarios.size();

                double meidaIdade = (double) somaIdades / totalUsuarios;

                System.out.println("\nNúmero total de usuários: " + totalUsuarios);
                System.out.println("\nMédia de idade dos usuários: " + meidaIdade);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
