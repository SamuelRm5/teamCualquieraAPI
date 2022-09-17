package com.mintic.teamCualquiera.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.repositorio.EnterpriseRepositorio;

@Service
public class EnterpriseService {

    EnterpriseRepositorio repository;

    public EnterpriseService( EnterpriseRepositorio repository ) {
        this.repository = repository;
    }

    public List<Enterprise> getEnterpriseList(){
        return this.repository.findAll();
    }

    public Enterprise createEnterprise(Enterprise newEnterprise){
        return this.repository.save(newEnterprise);
    }
    
}
