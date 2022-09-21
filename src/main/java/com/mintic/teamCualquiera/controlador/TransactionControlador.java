package com.mintic.teamCualquiera.controlador;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import com.mintic.teamCualquiera.modelo.Enterprise;
import com.mintic.teamCualquiera.modelo.Transaction;
import com.mintic.teamCualquiera.repositorio.TransactionRepositorio;
import com.mintic.teamCualquiera.services.MovementsService;

@RestController
@RequestMapping("/api")
@Controller
public class TransactionControlador {

    @Autowired
    TransactionRepositorio repo;

    MovementsService service;

    public TransactionControlador ( MovementsService service ){
        this.service = service;
    }

    @GetMapping("/ingresos")
    public List<Transaction> showMovementsAll( MovementsService service ){
        return this.service.getTransactionList();
    }

    @PostMapping("/ingresos")
    public RedirectView createMovement( @ModelAttribute Transaction transaction, Model model ){

        LocalDate currentDate = LocalDate.now();

        transaction.setCreatedAt(Date.valueOf(currentDate));

        model.addAttribute(transaction);
        this.service.createMovement(transaction);

        return new RedirectView("/ingresos");
    }

    @RequestMapping(value = "/enterprises/{id}/movements", method = RequestMethod.GET)
    public List<Transaction> showAll(@PathVariable Long id ) {
        return this.service.getTransactionById(id);
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

    @GetMapping("ingresosbyid")
    public void listAll( @Param("identerprise") Long id ){

        this.service.movementByID(id);

    }

}
