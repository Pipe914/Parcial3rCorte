package com.parcial.backend.parcialwebspring.repositories;

import java.util.HashMap;

import com.parcial.backend.parcialwebspring.entities.Componente;

public class OfertaFactory {
    private HashMap list = new HashMap();

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
