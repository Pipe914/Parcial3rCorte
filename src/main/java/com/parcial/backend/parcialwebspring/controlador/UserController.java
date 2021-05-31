package com.parcial.backend.parcialwebspring.controlador;

import com.parcial.backend.parcialwebspring.entities.Usuario;
import com.parcial.backend.parcialwebspring.services.Facade;
import com.parcial.backend.parcialwebspring.services.proxy.AESEncript;
import com.parcial.backend.parcialwebspring.services.proxy.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("buscarOferta.html")
    public String buscarOferta() {
        return "buscarOferta";
    }

    @GetMapping("crearEmpresa.html")
    public String crearEmpresa() {
        return "administrador/crearEmpresa";
    }

    @GetMapping("crearOferta.html")
    public String crearOferta() {
        return "administrador/crearOferta";
    }

    @GetMapping("modificadorOferta.html")
    public String modificarOfertaVista() {
        return "administrador/modificarOferta";
    }

    @PostMapping(value = "/login")

    public String login(@RequestParam(name = "userLogin", required = true, defaultValue = "no envio nada") String username,
            @RequestParam(name = "passLogin", required = true, defaultValue = "no envio nada") String password,
            @RequestParam(name = "tipologin", required = true, defaultValue = "no envio nada") String tipo,
            RedirectAttributes redirectAttrs) {
            key = proxy.verifyLogin(user, username, password);
        if (!key.equals("")) {
            redirectAttrs.addFlashAttribute("mensaje", "Ha ingresado correctamente!!").addFlashAttribute("clase",
                    "success");
            return "redirect:/administrador.html";
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Registro fallido, intente nuevamente")
                    .addFlashAttribute("clase", "success");
            return "redirect:/";
        }
    }

    @PostMapping(value = "/registro")
    public String asdf(@RequestParam(name = "userRegistro", required = true) String username,
            @RequestParam(name = "passRegistro", required = true) String password,
            @RequestParam(name = "tiporegistro", required = true) String tipo,
            RedirectAttributes redirectAttrs) {
            System.out.println(tipo);
            user = controlador.createUser(tipo, username, password);

        if (user != null) {
            redirectAttrs.addFlashAttribute("mensaje", "Se ha registrado correctamente!!").addFlashAttribute("clase",
                    "success");
            return "redirect:/";
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Registro fallido, intente nuevamente")
                    .addFlashAttribute("clase", "success");
            return "redirect:/";
        }
    }

    @PostMapping(value = "/crearEmpresa")
    public String crearEmpresa(
            @RequestParam(name = "nameEmpresa", required = true, defaultValue = "no envio nombre") String name,
            @RequestParam(name = "nit", required = true, defaultValue = "no envio nada") String nit,
            @RequestParam(name = "direccion", required = true, defaultValue = "No envio") String direccion,
            RedirectAttributes redirectAttrs) {

        String response = AESEncript.decrypt(controlador.action(AESEncript.encrypt("3/" + key+"/"+name+"/"+nit+"/"+direccion)));
        System.out.println(response);
        if (response.equals("La empresa se ha creado exitosamente")) {
            redirectAttrs.addFlashAttribute("mensaje", response).addFlashAttribute("clase",
                    "success");
            return "redirect:/crearEmpresa.html";
        } else {
            redirectAttrs.addFlashAttribute("mensaje", response)
                    .addFlashAttribute("clase", "success");
            return "redirect:/crearEmpresa.html";
        }
    }

    @PostMapping(value = "/crearOfertaBase")
    public String crearOfertaBase(RedirectAttributes redirectAttrs) {

        String response = AESEncript.decrypt(controlador.action(AESEncript.encrypt("4/" + key)));
        System.out.println(response);

        if (response.equals("Usted no tiene acceso para realizar esta acción!!!")
                || response.equals("La sesion no existe, ha caducado.")) {
            redirectAttrs.addFlashAttribute("mensaje", response)
                    .addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";
        } else {
            redirectAttrs.addFlashAttribute("mensaje", response).addFlashAttribute("clase",
                    "success");
            return "redirect:/crearOferta.html";
        }
    }

    @PostMapping(value = "/crearOfertaCompleta")
    public String crearOfertaCompleta(@RequestParam(name = "descripcion", required = true) String descipcion,
            @RequestParam(name = "sueldo", required = true) String sueldo,
            @RequestParam(name = "tiempo", required = true) String tiempo,
            @RequestParam(name = "contrato", required = true) String tipo, RedirectAttributes redirectAttrs) {

        String response = AESEncript.decrypt(controlador
                .action(AESEncript.encrypt("5/" + key + "/" + descipcion + "/" + tipo + "/" + tiempo + "/" + sueldo)));
        System.out.println(response);

        if (response.equals("Usted no tiene acceso para realizar esta acción!!!")
        || response.equals("La sesion no existe, ha caducado.")|| response== null) {
            // Mala
            redirectAttrs.addFlashAttribute("mensaje", response)
                    .addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";

        } else {
            // && sueldo != null && tiempo != null && tipoContrato != null)
            redirectAttrs.addFlashAttribute("mensaje", response).addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";
        }
    }

    @PostMapping(value = "/modificarOferta")
    public String modificarOferta() {

        String response = AESEncript.decrypt(controlador.action(AESEncript.encrypt("4/" + key)));
        System.out.println(response);

        if (response.equals("Usted no tiene acceso para realizar esta acción!!!")
                || response.equals("La sesion no existe, ha caducado.")) {
            // Mala
            return "";
        } else {
            // Buena
            return "";
        }
    }

    @PostMapping(value = "/buscarOfertaAspirante")
    public String buscarOfertaAspirante() {

        String response = AESEncript.decrypt(controlador.action(AESEncript.encrypt("4/" + key)));
        System.out.println(response);

        if (response.equals("Usted no tiene acceso para realizar esta acción!!!")
                || response.equals("La sesion no existe, ha caducado.")) {
            // Mala
            return "";
        } else {
            // Buena
            return "";
        }
    }

}
