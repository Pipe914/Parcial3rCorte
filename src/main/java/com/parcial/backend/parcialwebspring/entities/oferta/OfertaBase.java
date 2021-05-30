package com.parcial.backend.parcialwebspring.entities.oferta;

import com.parcial.backend.parcialwebspring.entities.Componente;

// Clase base oferta
public class OfertaBase implements Componente{
// Variables globales
    private String id;

// Constructor
    public OfertaBase(String iD){
        id = iD;
    }
    
// Metodos de clase
    public void setId(String iD){
        id = iD;
    }

    public String getId(){
        return id;
    }
    @Override
    public String imprimirOferta() {
        return "La oferta laboral consta de:\n";
    }
    public String optionalGetId(){
        return getId();
    }
}
