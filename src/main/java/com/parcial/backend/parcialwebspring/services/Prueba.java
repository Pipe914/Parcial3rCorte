package com.parcial.backend.parcialwebspring.services;

public class Prueba {
    public Prueba() {

    }

    public boolean verifyL(String user, String password){
        if (user.equals("asd")&&password.equals("123")) {
            return true;
        }else{
            return false;
        }
    }
}
