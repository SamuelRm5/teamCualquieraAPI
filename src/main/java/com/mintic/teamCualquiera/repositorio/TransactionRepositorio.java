package com.mintic.teamCualquiera.repositorio;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mintic.teamCualquiera.modelo.Transaction;

@Repository
public interface TransactionRepositorio extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transaction WHERE enterprise=:id", nativeQuery=true)
    List<Transaction> transactionByID ( Long id );

    @Query(value = "DELETE FROM transaction WHERE enterprise=:id", nativeQuery=true)
    void deleteTransactionByID ( Long id );
    
}
