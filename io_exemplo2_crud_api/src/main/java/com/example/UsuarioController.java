package com.example;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<Usuario>();
    }

    public void read() {
        try {
            // estabelecer conexao
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // verificar status de conexao
            int status = con.getResponseCode();
            if (status != 200) {// diferente de 200 lançar uma exception
                throw new Exception("Erro de Conexão");
            }

            // buffer(gravar os dados da api na memoria)
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String linha;

            // converter em um arquivo de texto(string)
            StringBuffer content = new StringBuffer();

            // le a reposta da api linha por linha
            while ((linha = br.readLine()) != null) {
                content.append(linha);
            }
            br.close();

            //converter o arquivo de texto para dados da classe usuario
            JSONArray dadosUsuarios = new JSONArray(content.toString());
            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                    usuarioJson.getString("id"),
                    usuarioJson.getString("nome"),
                    usuarioJson.getInt("idade"),
                    usuarioJson.getString("endereco")
                ));
            }
            System.out.println(usuarios.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void create(Usuario usuario) {
        try {
              // estabelecer conexao
              url = new URL("http://localhost:3000/usuarios");
              HttpURLConnection con = (HttpURLConnection) url.openConnection();
              con.setRequestMethod("POST");
              con.setRequestProperty("Content-Type", "application/json; utf-8");
              con.setRequestProperty("Acceot", "application/json");
              con.setDoInput(true);

              //criando o objeto json
              JSONObject usuarioJson = new JSONObject();
                usuarioJson.put("nome", usuario.getNome());
                usuarioJson.put("idade", usuario.getIdade());
                usuarioJson.put("endereco", usuario.getEndereco());

                //enviar dados para a API
                try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(con.getOutputStream(), "UTF-8"))){
                    bw.write(usuarioJson.toString());
                    bw.flush();
                }

                //verificar o status da reposta
                int status = con.getResponseCode();
                if (status != HttpURLConnection.HTTP_CREATED) {
                    throw new Exception("Erro ao cadastrar novo usuario "+ status);
                }
                    System.out.println("Usuario cadastrado com sucesso");
                } catch (Exception e) {
                    // TODO: handle exception
                }

        } 
    }
