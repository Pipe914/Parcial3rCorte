package com.parcial.backend.parcialwebspring.repositories;

import java.util.HashMap;

import com.parcial.backend.parcialwebspring.entities.Componente;

import org.springframework.stereotype.Repository;
@Repository
public class OfertaFactory {
    private HashMap<String,Componente> list = new HashMap<String,Componente>();

    public void saveOferta(String id, Componente oferta) {
        list.put(id, oferta);
    }
    public Componente getOferta(String id){
        return (Componente) list.get(id);
    }
    public int getSize(){
        return list.size();
    }
}
