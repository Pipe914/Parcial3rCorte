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
        return "aspirante";   
    }
    @GetMapping("/administradoe")
    public String ingresoAd(){
        return "administrador";   
    }
    @GetMapping("/buscarOferta")
    public String buscarOferta(){
        return "buscarOferta"; 
    }
    @GetMapping("/crearEmpresa")
    public String crearEmpresa(){
        return "crearEmpresa"; 
    }
    @GetMapping("/crearOferta")
    public String crearOferta(){
        return "crearOferta"; 
    }
    @GetMapping("/modificarOferta")
    public String modificarOferta(){
        return "modificarOferta"; 
    }
    


    
    @PostMapping("/prueba")
    public String verifyLogin(@RequestParam(name = "user", required = false, defaultValue = "no envio nada") String user, @RequestParam(name = "pass", required = false, defaultValue = "no envio nada") String password){
        return "";
    }
    
    
}