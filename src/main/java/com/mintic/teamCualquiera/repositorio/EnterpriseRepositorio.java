package com.mintic.teamCualquiera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.teamCualquiera.modelo.Enterprise;

@Repository
public interface EnterpriseRepositorio extends JpaRepository<Enterprise, Long> {
    
}
