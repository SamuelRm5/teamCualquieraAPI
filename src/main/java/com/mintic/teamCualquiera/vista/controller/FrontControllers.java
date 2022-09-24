package com.mintic.teamCualquiera.vista.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mintic.teamCualquiera.controlador.EmployeeControlador;
import com.mintic.teamCualquiera.modelo.Employee;
import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.modelo.User;
import com.mintic.teamCualquiera.services.EnterpriseService;
import com.mintic.teamCualquiera.services.UserService;


@Controller
public class FrontControllers {

    EnterpriseService service;
    UserService userService;
    EmployeeControlador employeeConroller;

    public FrontControllers( EnterpriseService service, UserService userService, EmployeeControlador employeeConroller ) { 
        this.service = service; 
        this.userService = userService;
        this.employeeConroller = employeeConroller;
    }
   
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){ 
        if (principal != null) {
            
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);

        }
        return "login"; 
    }

    @GetMapping("/inicio")
    public String index(){ 
        return "index"; 
    }

    @GetMapping("/usuarios")
    public String usuarios( Model model ){ 
        List<Employee> employees = this.employeeConroller.listar();
        model.addAttribute("employees", employees);
        return "usuarios"; 
    }
    @GetMapping("/usuarionuevo")
    public String nuevoUsuario(Model model){ 
        List<Enterprise> enterprises = this.service.getEnterpriseList();
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("employee", new Employee());
        return "newusuario"; 
    }

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
