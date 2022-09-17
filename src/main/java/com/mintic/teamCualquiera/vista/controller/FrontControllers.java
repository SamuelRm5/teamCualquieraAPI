package com.mintic.teamCualquiera.vista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mintic.teamCualquiera.controlador.EnterpriseControlador;
import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.repositorio.EnterpriseRepositorio;
import com.mintic.teamCualquiera.services.EnterpriseService;


@Controller
public class FrontControllers {

    EnterpriseService service;

    public FrontControllers( EnterpriseService service ) { this.service = service; }
   
    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping("/ingresos")
    public String ingresos(){ return "ingresos"; }

    @GetMapping("/usuarios")
    public String usuarios(){ return "usuarios"; }
    @GetMapping("/usuarionuevo")
    public String nuevoUsuario(){ return "newusuario"; }

    @GetMapping("/empresas")
    public String empresas(Model model){
        List<Enterprise> enterprises = this.service.getEnterpriseList();
        model.addAttribute("enterprises", enterprises);
        return "empresas";
    }

    @GetMapping("empresanueva")
    public String empresaNueva(Model model){ 
        model.addAttribute("enterprise", new Enterprise());
        return "newempresa"; 
    }

}
