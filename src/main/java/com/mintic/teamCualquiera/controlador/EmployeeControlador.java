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
    public List<Employee> listar() {
        return repo.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Employee listarUno(@PathVariable String id) {
        return repo.findById(id).get();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Employee crear(@RequestBody Employee employee) {
        return repo.save(employee);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public Employee actualizar(@PathVariable String id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        return repo.save(employee);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String eliminar(@PathVariable String id) {
        repo.deleteById(id);
        return "Employee deleted";
    }

}
