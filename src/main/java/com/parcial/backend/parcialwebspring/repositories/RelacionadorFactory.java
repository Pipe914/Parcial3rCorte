package com.parcial.backend.parcialwebspring.repositories;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
@Repository
public class RelacionadorFactory {
    private HashMap<String, String> key_user = new HashMap<String, String>();
    private HashMap<String, String> user_empresa = new HashMap<String, String>();
    private HashMap<String, String> user_oferta = new HashMap<String, String>();

//Metodos HashMap key_user
    public void saveKeyUsuario(String key, String value)
    {
        key_user.put(key, value);

    }
    public String getKeyUsuario(String key){
        return (String)key_user.get(key); 
    }
    public boolean deleteKeyUsuario(String key){
        boolean result = false;
        int tamañoInicial = key_user.size();
        key_user.remove(key);
        if(tamañoInicial>key_user.size()){
            result = true;
        }
        return result;
    }
//Metodos HashMap user_empresa
    public void saveUsuarioEmpresa(String username, String nit)
    {
        user_empresa.put(username, nit);
    }
    public String getUsuarioEmpresa(String username){
        return (String)user_empresa.get(username); 
    }
//Metodos HashMap user_oferta
    public void saveUsuarioOferta(String username, String id)
    {
        user_oferta.put(username, id);

    }
    public String getUsuarioOferta(String username){
        return (String)user_oferta.get(username); 
    }
}
