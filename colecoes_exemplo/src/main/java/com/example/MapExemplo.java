package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String,Integer> nomeIdade;

    public MapExemplo(){
        nomeIdade = new HashMap<>();
    }

    public void adicionarNomeIdade(){
        nomeIdade.put("Maria", 23);
    }

    public void listarNomesIdade(){
        
    }
}
