package com.mintic.teamCualquiera.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.modelo.Transaction;
import com.mintic.teamCualquiera.repositorio.TransactionRepositorio;

@RestController
@RequestMapping("/api")
public class TransactionControlador {

    @Autowired
    TransactionRepositorio repo;

    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.GET)
    public List<Transaction> showAll(@PathVariable Long id ) {
        return repo.transactionByID( id );
    }
    
    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.POST)
    public Transaction create(@PathVariable Long id, @RequestBody Transaction transaction) {

        Enterprise enterprise = new Enterprise();
        enterprise.setId(id);

        Boolean entry = (transaction.getAmount() >= 0);
        transaction.setEntry( entry );
        transaction.setEnterprise( enterprise );

        return repo.save( transaction );
    }

    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.PATCH)
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transaction) {

        Enterprise enterprise = new Enterprise();
        enterprise.setId(id);

        Boolean entry = (transaction.getAmount() >= 0);
        transaction.setEntry( entry );
        transaction.setEnterprise( enterprise );

        return repo.save( transaction );
    }

    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id ) {
        repo.deleteTransactionByID( id );
        return new ResponseEntity<>("Movement deleted",HttpStatus.OK);
    }

}
