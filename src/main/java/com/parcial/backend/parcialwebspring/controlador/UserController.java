package com.parcial.backend.parcialwebspring.controlador;

import com.parcial.backend.parcialwebspring.services.Prueba;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @GetMapping("/")
    public String home(){
        return "Home";
    }
    @GetMapping("/login")
    public String login(){
        return "Login";
    }
    
    @PostMapping("/")
    //@ResponseBody
    public String verifyLogin(@RequestParam(name = "user", required = false, defaultValue = "no envio nada") String user, @RequestParam(name = "pass", required = false, defaultValue = "no envio nada") String password){
        
        /*Prueba xd = new Prueba();
        if(xd.verifyL(user, password)){
            return "Login";
        }else{
            return "<h1>Intente Nuevamente</h1>";
        }*/
        
        return "Home";
    }
}