package com.mintic.teamCualquiera.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mintic.teamCualquiera.modelo.Transaction;

@Repository
public interface TransactionRepositorio extends JpaRepository<Transaction, Long> {
    
}
