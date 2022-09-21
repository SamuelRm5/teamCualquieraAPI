package com.mintic.teamCualquiera.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mintic.teamCualquiera.modelo.Transaction;
import com.mintic.teamCualquiera.repositorio.TransactionRepositorio;

@Service
public class MovementsService {

    TransactionRepositorio repository;

    public MovementsService(TransactionRepositorio repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactionList(){
        return this.repository.findAll();
    }

    public List<Transaction> getTransactionById(Long id){
        return this.repository.transactionByID(id);
    }

    public String createMovement(Transaction newTransaction){
        this.repository.save(newTransaction);
        return "ok";
    }

    public List<Transaction> movementByID( Long id ){
        return this.repository.transactionByID(id);
    }    
}
