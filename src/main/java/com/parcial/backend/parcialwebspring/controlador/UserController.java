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
    public String modificarOferta() {
        return "administrador/modificarOferta";
    }

    @PostMapping(value = "/login")

    public String login(@RequestParam(name = "userLogin", required = true, defaultValue = "no envio nada") String user,
            @RequestParam(name = "passLogin", required = true, defaultValue = "no envio nada") String password,
            @RequestParam(name = "tipologin", required = true, defaultValue = "no envio nada") String tipo,
            RedirectAttributes redirectAttrs) {
        if (user != null) {
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

    public String asdf(
            @RequestParam(name = "userRegistro", required = false, defaultValue = "no envio nada") String user,
            @RequestParam(name = "passRegistro", required = false, defaultValue = "no envio nada") String password,
            RedirectAttributes redirectAttrs) {
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
            @RequestParam(name = "nameEmpresa", required = true, defaultValue = "no envio nombre") String nameEmpresa,
            @RequestParam(name = "nit", required = true, defaultValue = "no envio nada") String nit,
            @RequestParam(name = "direccion", required = true, defaultValue = "no envio nada") String direccion,
            RedirectAttributes redirectAttrs) {
        if (nameEmpresa != null) {
            redirectAttrs.addFlashAttribute("mensaje", "Empresa creada correctamente").addFlashAttribute("clase",
                    "success");
            return "redirect:/crearEmpresa.html";
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Registro de empresa fallido, intente nuevamente")
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
                    redirectAttrs.addFlashAttribute("mensaje", "Registro de empresa fallido, intente nuevamente")
                    .addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Registro de empresa Exitoso")
            .addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";
        }
    }

    @PostMapping(value = "/crearOfertaCompleta")
    public String crearOfertaCompleta(
            @RequestParam(name = "descripcion", required = true, defaultValue = "no envio nada") String descripcion,
            @RequestParam(name = "sueldo", required = true, defaultValue = "no envio nada") String sueldo,
            @RequestParam(name = "tiempo", required = true, defaultValue = "no envio nada") String tiempo,
            @RequestParam(name = "tipoContrato", required = true, defaultValue = "no envio nada") String tipoContrato,
            RedirectAttributes redirectAttrs) {

        String response = AESEncript.decrypt(controlador.action(AESEncript.encrypt("5/" + key)));
        System.out.println(response);

        if (response.equals("Usted no tiene acceso para realizar esta acción!!!")
        || response.equals("La sesion no existe, ha caducado.")|| response== null) {
            // Mala
            redirectAttrs.addFlashAttribute("mensaje", "Registro de empresa fallido, intente nuevamente")
                    .addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";

        } else {
            // && sueldo != null && tiempo != null && tipoContrato != null)
            redirectAttrs.addFlashAttribute("mensaje", "Empresa creada correctamente").addFlashAttribute("clase", "success");
            return "redirect:/crearOferta.html";
        }

    }
}
