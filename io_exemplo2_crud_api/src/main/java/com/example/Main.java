package com.example;

public class Main {
    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        // uc.createUser(new Usuario(
        //     "", 
        //     "Ana", 
        //     45, 
        //     "Rua c"));
        uc.read();
        // uc.updateUser(new Usuario(
        //     "9b8a", 
        //     "Ana Clara", 
        //     47, 
        //     "Rua c"));
        uc.deleteUser("9b8a");
    }
}