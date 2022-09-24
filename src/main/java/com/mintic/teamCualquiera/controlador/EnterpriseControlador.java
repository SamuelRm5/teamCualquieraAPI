package com.mintic.teamCualquiera.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.repositorio.EnterpriseRepositorio;
import com.mintic.teamCualquiera.services.EnterpriseService;

@RestController
@RequestMapping("/api")
public class EnterpriseControlador {
    
    @Autowired
    EnterpriseRepositorio repo;

    EnterpriseService service;
    EnterpriseControlador(EnterpriseService service){
        this.service = service;
    }

    @GetMapping("/enterprises")
    public List<Enterprise> showAll() {
        return this.service.getEnterpriseList();
    }

    @RequestMapping(value = "/enterprises/{id}", method = RequestMethod.GET)
    public Enterprise showOne(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/enterprises", method = RequestMethod.POST)
    public RedirectView create(@ModelAttribute Enterprise enterprise, Model model) {

        LocalDate currentDate = LocalDate.now();

        enterprise.setCreatedAt( Date.valueOf(currentDate) );

        model.addAttribute(enterprise); 
        this.service.createEnterprise(enterprise);
        return new RedirectView("/empresas");
    }

    @RequestMapping(value = "/enterprises/{id}", method = RequestMethod.PATCH)
    public Enterprise update(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        enterprise.setId(id);
        return repo.save(enterprise);
    }

    @RequestMapping(value = "/enterprises/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        repo.deleteById( id );
        return "Enterprise deleted";
    }

}
