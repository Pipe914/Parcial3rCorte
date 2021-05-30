package com.parcial.backend.parcialwebspring.repositories; 

import java.util.HashMap;

import com.parcial.backend.parcialwebspring.entities.Usuario;

public class UsuarioFactory{
    private HashMap listUsuario = new HashMap();

    public void saveUsuario(String username, Usuario user)
    {
        listUsuario.put(username, user);

    }
    public Usuario getUsuario(String username){
        return (Usuario)listUsuario.get(username); 
    }
}