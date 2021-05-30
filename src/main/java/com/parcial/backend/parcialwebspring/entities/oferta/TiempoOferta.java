package com.parcial.backend.parcialwebspring.entities.oferta;
import com.parcial.backend.parcialwebspring.entities.Componente;

// Clase propiedad oferta: Descripcion
public class TiempoOferta extends ModificadorOferta{
// Variables globales
    private String tiempo;

// Constructor
    public TiempoOferta(Componente nuevaOferta, String tiempo) {
        super(nuevaOferta);
        this.tiempo = tiempo;
    }

// Metodos de clase
    public String imprimirOferta(){
        return nuevaOferta.imprimirOferta() + addTiempoOferta();
    }

    private String addTiempoOferta(){
        return "El tiempo del contrato es: " + this.tiempo + "\n";
    }
    public String optionalGetId(){
        return nuevaOferta.optionalGetId();
    }
}
