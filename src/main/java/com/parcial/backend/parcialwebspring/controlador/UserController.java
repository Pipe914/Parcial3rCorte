package com.parcial.backend.parcialwebspring.controlador;

import com.parcial.backend.parcialwebspring.services.proxy.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping(value = "/")
    public String home() {
        return "Index";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam(name = "userLogin", required = true, defaultValue = "no envio nada") String user,
            @RequestParam(name = "passLogin", required = true, defaultValue = "no envio nada") String password,
            @RequestParam(name = "tipologin", required = true, defaultValue = "no envio nada") String tipo) {
        System.out.println(user + "  " + password + " " + tipo);
        Login controladorLogin = Login.getLogin();
        return "se logueo";
    }

    @PostMapping(value = "/registro")
    @ResponseBody
    public String asdf(
            @RequestParam(name = "userRegistro", required = false, defaultValue = "no envio nada") String user,
            @RequestParam(name = "passRegistro", required = false, defaultValue = "no envio nada") String password) {
        System.out.println(user + "  " + password);
        return "se registro";
    }

}