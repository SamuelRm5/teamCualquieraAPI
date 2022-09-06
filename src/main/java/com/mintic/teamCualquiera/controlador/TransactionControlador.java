package com.mintic.teamCualquiera.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mintic.teamCualquiera.modelo.Transaction;
import com.mintic.teamCualquiera.repositorio.TransactionRepositorio;

@RestController
@RequestMapping("/api")
public class TransactionControlador {

    @Autowired
    TransactionRepositorio repo;

    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.GET)
    public List<Transaction> showAll() {
        return repo.findAll();
    }
    
    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.POST)
    public Transaction create(@RequestBody Transaction transaction) {
        return repo.save(transaction);
    }
    
    


    
}
