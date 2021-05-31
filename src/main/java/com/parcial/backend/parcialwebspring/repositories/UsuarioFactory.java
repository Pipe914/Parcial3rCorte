package com.parcial.backend.parcialwebspring.repositories; 

import java.util.HashMap;

import com.parcial.backend.parcialwebspring.entities.Usuario;
import org.springframework.stereotype.Repository;
@Repository
public class UsuarioFactory{
    private HashMap<String, Usuario> listUsuario = new HashMap<String, Usuario>();

    public void saveUsuario(String username, Usuario user)
    {
        listUsuario.put(username, user);

    }
    public Usuario getUsuario(String username){
        return (Usuario)listUsuario.get(username); 
    }
}