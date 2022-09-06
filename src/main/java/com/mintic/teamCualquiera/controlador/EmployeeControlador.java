package com.mintic.teamCualquiera.controlador;
import com.mintic.teamCualquiera.modelo.Employee;
import com.mintic.teamCualquiera.repositorio.EmployeeRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeControlador {
    
    @Autowired
    EmployeeRepositorio repo;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Employee> listar(@RequestBody Employee employee) {
        return repo.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Employee crear(@RequestBody Employee employee) {
        return repo.save(employee);
    }

}
