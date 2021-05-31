package com.parcial.backend.parcialwebspring.controlador;

import com.parcial.backend.parcialwebspring.services.proxy.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    
    @GetMapping("/")
    public String home(){
        return "Index";
    }
    @GetMapping("/aspirante.html")
    public String ingresoAs(){
        return "aspirante/aspirante";   
    }
    @GetMapping("/administrador.html")
    public String ingresoAd(){
        return "administrador/administrador";   
    }
    @GetMapping("/buscarOfertaAdmin.html")
    public String buscarOfertaAdmin(){
        return "administrador/buscarOfertaAdmin"; 
    }
    @GetMapping("/buscarOferta.html")
    public String buscarOferta(){
        return "buscarOferta"; 
    }
    @GetMapping("crearEmpresa.html")
    public String crearEmpresa(){
        return "administrador/crearEmpresa";    
    }
    @GetMapping("crearOferta.html")
    public String crearOferta(){
        return "administrador/crearOferta"; 
    }
    @GetMapping("modificarOferta.html")
    public String modificarOferta(){
        return "administrador/modificarOferta"; 
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam(name = "userLogin", required = true, defaultValue = "no envio nada") String user,
            @RequestParam(name = "passLogin", required = true, defaultValue = "no envio nada") String password,
            @RequestParam(name = "tipologin", required = true, defaultValue = "no envio nada") String tipo) {
        System.out.println(user + "  " + password + " " + tipo);
        return "se logueo";
    }

    @PostMapping(value = "/registro")
    @ResponseBody
    public String asdf(
            @RequestParam(name = "userRegistro", required = false, defaultValue = "no envio nada") String user,
            @RequestParam(name = "passRegistro", required = false, defaultValue = "no envio nada") String password, RedirectAttributes redirectAttrs ) {
        System.out.println(user + "  " + password);
        redirectAttrs
            .addFlashAttribute("mensaje", "Agregado correctamente")
            .addFlashAttribute("clase", "success");
        return "se registro";
    }
    
}