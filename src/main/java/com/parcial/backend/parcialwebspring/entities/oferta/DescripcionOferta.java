package com.parcial.backend.parcialwebspring.entities.oferta;

import com.parcial.backend.parcialwebspring.entities.Componente;

// Clase propiedad oferta: Descripcion
public class DescripcionOferta extends ModificadorOferta{
// Variables globales
    private String descripcion;

// Constructor
    public DescripcionOferta(Componente nuevaOferta, String descripcion){
        super(nuevaOferta);
        this.descripcion = descripcion;
    }

// Metodos de clase
    public String imprimirOferta(){
        return nuevaOferta.imprimirOferta() + addDescripcion();
    }
    private String addDescripcion(){
        return "\nLa descripción es: "+ this.descripcion +"\n";
    }
    public String optionalGetId(){
        return nuevaOferta.optionalGetId();
    }

}
