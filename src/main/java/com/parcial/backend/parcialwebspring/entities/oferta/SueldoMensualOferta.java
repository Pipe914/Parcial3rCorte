package com.parcial.backend.parcialwebspring.entities.oferta;

import com.parcial.backend.parcialwebspring.entities.Componente;

// Clase propiedad oferta: Sueldo Oferta
public class SueldoMensualOferta extends ModificadorOferta{
// Variables globales
    private String sueldo;

// Constructor
    public SueldoMensualOferta(Componente nuevaOferta, String sueldo){
        super(nuevaOferta);
        this.sueldo = sueldo;
    }

// Metodos de clase
    public String imprimirOferta(){
        return nuevaOferta.imprimirOferta() + addSueldo();
    }
    private String addSueldo(){
        return "El sueldo mensual del contrato es: " + this.sueldo + "\n";
    }
    public String optionalGetId(){
        return nuevaOferta.optionalGetId();
    }
    
}
