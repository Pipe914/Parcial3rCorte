package com.parcial.backend.parcialwebspring.entities.oferta;

import com.parcial.backend.parcialwebspring.entities.Componente;

// Clase modificadora de oferta
public abstract class ModificadorOferta implements Componente{
// Variables globales
    protected Componente nuevaOferta;

// Constructor
    public ModificadorOferta (Componente nuevaOferta){
        this.nuevaOferta = nuevaOferta;
    }

// Metodos de clase
    public String imprimirOferta(){
        return nuevaOferta.imprimirOferta();
    }
    public String optionalGetId(){
        return nuevaOferta.optionalGetId();
    }
}
