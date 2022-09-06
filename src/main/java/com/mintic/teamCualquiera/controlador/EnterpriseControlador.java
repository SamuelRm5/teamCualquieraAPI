package com.mintic.teamCualquiera.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.repositorio.EnterpriseRepositorio;

@RestController
@RequestMapping("/api")
public class EnterpriseControlador {
    
    @Autowired
    EnterpriseRepositorio repo;

    @RequestMapping(value = "/enterprises", method = RequestMethod.GET)
    public List<Enterprise> showAll() {
        return repo.findAll();
    }

    @RequestMapping(value = "/enterprises/{id}", method = RequestMethod.GET)
    public Enterprise showOne(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/enterprises", method = RequestMethod.POST)
    public Enterprise create(@RequestBody Enterprise enterprise) {
        return repo.save(enterprise);
    }

    @RequestMapping(value = "/enterprises/{id}", method = RequestMethod.PATCH)
    public Enterprise update(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        enterprise.setId(id);
        return repo.save(enterprise);
    }

}
