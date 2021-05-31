package com.parcial.backend.parcialwebspring.controlador;

import java.io.StringBufferInputStream;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.parcial.backend.parcialwebspring.entities.Usuario;
import com.parcial.backend.parcialwebspring.services.Facade;
import com.parcial.backend.parcialwebspring.services.proxy.AESEncript;
import com.parcial.backend.parcialwebspring.services.proxy.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private Usuario user = null;
    private String key = "";
    private Facade controlador = Facade.getFacade();
    private Login proxy = Login.getLogin();

    @GetMapping("/")
    public String home() {
        return "Index";
    }

    @GetMapping("/aspirante.html")
    public String ingresoAs() {
        return "aspirante/aspirante";
    }

    @GetMapping("/administrador.html")
    public String ingresoAd() {
        return "administrador/administrador";
    }
<<<<<<< HEAD
    @GetMapping("/buscarOfertaAdmin.html")
    public String buscarOfertaAdmin(){
        return "administrador/buscarOfertaAdmin"; 
    }
    @GetMapping("/buscarOferta.html")
    public String buscarOferta(){
        return "buscarOferta"; 
=======

    @GetMapping("buscarOferta.html")
    public String buscarOferta() {
        return "buscarOferta";
>>>>>>> 49b8326068fe54d55d10e30a917ed6917f4b2679
    }

    @GetMapping("crearEmpresa.html")
    public String crearEmpresa() {
        return "administrador/crearEmpresa";
    }

    @GetMapping("crearOferta.html")
    public String crearOferta() {
        return "administrador/crearOferta";
    }
<<<<<<< HEAD
    @GetMapping("modificarOferta.html")
    public String modificarOferta(){
        return "administrador/modificarOferta"; 
=======

    @GetMapping("modificarOferta.html")
    public String modificarOferta() {
        return "administrador/modificarOferta";
>>>>>>> 49b8326068fe54d55d10e30a917ed6917f4b2679
    }

    @PostMapping(value = "/login")
    public String login(
            @RequestParam(name = "userLogin", required = true, defaultValue = "no envio nada") String username,
            @RequestParam(name = "passLogin", required = true, defaultValue = "no envio nada") String password,
            @RequestParam(name = "tipologin", required = true, defaultValue = "no envio nada") String tipo) {

        System.out.println(username + "  " + password + " " + tipo);
        key = proxy.verifyLogin(user, username, password);
        if(!key.equals("")){
            return ingresoAd();
        }else{
            return home();
        }
    }

    @PostMapping(value = "/registro")
    public String asdf(
            @RequestParam(name = "userRegistro", required = true, defaultValue = "no envio nada") String username,
            @RequestParam(name = "passRegistro", required = true, defaultValue = "no envio nada") String password) {
        System.out.println(username + "  " + password);

        user = controlador.createUser("1", username, password);
        if(user != null){
            return home();
        }else{
            return home();
        }
       
    }

    @PostMapping(value = "/crearEmpresa")
    @ResponseBody
    public String crearEmpresa(
            @RequestParam(name = "nombre", required = true, defaultValue = "no envio nada") String nombre,
            @RequestParam(name = "nit", required = true, defaultValue = "no envio nada") String nit,
            @RequestParam(name = "direccion", required = true, defaultValue = "No envio") String direccion) {

        System.out.println(nombre + "  " + nit + " " + direccion);
        String response = AESEncript.decrypt(controlador.action(AESEncript.encrypt("3/"+key+"/"+nombre+"/"+nit+"/"+direccion)));
        System.out.println(response);
        if(response.equals("La empresa se ha creado exitosamente")){
            return "se creo correctamente";
        }else{
            return "No se creo correctamente";
        }

    }

}