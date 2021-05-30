package com.parcial.backend.parcialwebspring.controlador;

import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("Login")
      public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }   
    

}