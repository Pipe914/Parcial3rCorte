package com.parcial.backend.parcialwebspring.repositories;

import java.util.HashMap;

import com.parcial.backend.parcialwebspring.entities.Empresa;

import org.springframework.stereotype.Repository;
@Repository
public class EmpresaFactory {
    private HashMap<String,Empresa> list = new HashMap<String,Empresa>();

    public void saveEmpresa(String nit, Empresa empresa) {
        list.put(nit, empresa);
    }
    public Empresa getEmpresa(String nit){
        return (Empresa) list.get(nit);
    }
}
 