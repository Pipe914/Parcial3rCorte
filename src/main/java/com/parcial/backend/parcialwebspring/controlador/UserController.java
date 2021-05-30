package com.parcial.backend.parcialwebspring.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    @GetMapping("/")
    public String home(){
        return "login/Index";
    }
  
    @PostMapping("/prueba")
    public String verifyLogin(@RequestParam(name = "user", required = false, defaultValue = "no envio nada") String user, @RequestParam(name = "pass", required = false, defaultValue = "no envio nada") String password){
        return "";
    }
    
}