package com.parcial.backend.parcialwebspring.services.proxy;

import com.parcial.backend.parcialwebspring.entities.Usuario;

// Interfaz para metodos proxy
public interface ILogin {
    // Metodo de verificacion de login
    public String verifyLogin(Usuario user, String username, String password);
    
}
