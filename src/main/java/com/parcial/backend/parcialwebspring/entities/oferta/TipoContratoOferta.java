package com.parcial.backend.parcialwebspring.entities.oferta;

import com.parcial.backend.parcialwebspring.entities.Componente;

// Clase propiedad oferta: Tipo Contrato
public class TipoContratoOferta extends ModificadorOferta{
// Variables globales
    private String tipoContrato;

// Constructor
    public TipoContratoOferta(Componente nuevaOferta, String tipoContrato) {
        super(nuevaOferta);
        this.tipoContrato = tipoContrato;
    }

// Metodos de clase
    public String imprimirOferta(){
        return nuevaOferta.imprimirOferta() + addTipoContrato();
    }
    private String addTipoContrato(){
        return "El tipo de contrato es: " + this.tipoContrato + "\n";
    }
    public String optionalGetId(){
        return nuevaOferta.optionalGetId();
    }
}
