package com.mintic.teamCualquiera.vista.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.mintic.teamCualquiera.controlador.EmployeeControlador;
import com.mintic.teamCualquiera.modelo.Employee;
import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.modelo.Transaction;
import com.mintic.teamCualquiera.services.EnterpriseService;
import com.mintic.teamCualquiera.services.MovementsService;


@Controller
public class FrontMovements {

    MovementsService service;
    EnterpriseService serviceEnterprise;
    EmployeeControlador controladorEmployee;

    public FrontMovements(MovementsService service, EnterpriseService serviceEnterpise,EmployeeControlador controladorEmployee) {
        this.service = service;
        this.serviceEnterprise = serviceEnterpise;
        this.controladorEmployee = controladorEmployee;
    }

    @GetMapping("/ingresos")
    public String movements( Model model ){
        List<Transaction> movements = this.service.getTransactionList();
        model.addAttribute("movements", movements);
        return "ingresos";
    }

    @GetMapping("/ingresonuevo")
    public String newMovement( Model model ){
        List<Enterprise> enterprises = this.serviceEnterprise.getEnterpriseList();
        model.addAttribute("enterprises", enterprises);

        List<Employee> employees = this.controladorEmployee.listar();
        model.addAttribute("employees", employees);
        model.addAttribute("movement", new Transaction());
        return "newingreso";
    }

    @GetMapping("/ingresoID")
    public String movementByID( Model model, @RequestParam Long identerprise ){

        if ( identerprise == null ) {
            new RedirectView("ingresos");
        }
        else{
            
            List<Transaction> movements = service.movementByID( identerprise );
            model.addAttribute("movements", movements);
        }

        return "ingresos";
    }

    
}
