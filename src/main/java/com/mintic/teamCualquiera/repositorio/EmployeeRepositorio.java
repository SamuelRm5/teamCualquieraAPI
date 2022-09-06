package com.mintic.teamCualquiera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.teamCualquiera.modelo.Employee;

@Repository
public interface EmployeeRepositorio extends JpaRepository<Employee, String>{
    
}
