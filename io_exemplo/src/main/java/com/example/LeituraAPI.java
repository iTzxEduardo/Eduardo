package com.example;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class LeituraAPI {
    public void exemplo(){
        try {
            URL url = new URL("https://api.github.com/users/iTzxEduardo");
            HttpURLConnection con =  (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status!=200){
                throw new Exception("Erro de Conexão");              
            }

            //Conexão estabelecida
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            //laço de repetição
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }
}
