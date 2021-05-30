package com.parcial.backend.parcialwebspring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    @GetMapping("/")
    public String home(){
        return "Index";
    }
    @GetMapping("/aspirante")
    public String ingresoAs(){
        return "aspirante/aspirante";   
    }
    @GetMapping("/administrador")
    public String ingresoAd(){
        return "administrador/administrador";   
    }
    @GetMapping("/buscarOfertaAdministrador")
    public String buscarOfertaAdministrador(){
        return "buscarOferta"; 
    }  
    
    @GetMapping("/buscarOfertaAspirante")
    public String buscarOfertaAspirante(){
        return "buscarOferta"; 
    }
    @GetMapping("administrador/crearEmpresa.html")
    public String crearEmpresa(){
        return "administrador/crearEmpresa"; 
    }
    @GetMapping("administrador/crearOferta")
    public String crearOferta(){
        return "administrador/crearOferta"; 
    }
    @GetMapping("administrador/modificarOferta")
    public String modificarOferta(){
        return "administrador/modificarOferta"; 
    }
    


    
    @PostMapping("/prueba")
    public String verifyLogin(@RequestParam(name = "user", required = false, defaultValue = "no envio nada") String user, @RequestParam(name = "pass", required = false, defaultValue = "no envio nada") String password){
        return "";
    }
    
    
}