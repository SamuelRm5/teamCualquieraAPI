package com.mintic.teamCualquiera.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Float amount;

    @Column
    private Boolean entry;

    @Column
    private String concept;

    @Column
    private Date updatedAt;

    @Column
    private Date createdAt;

    @ManyToOne
    @JoinColumn( name = "enterprise", referencedColumnName = "id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn( name = "employee", referencedColumnName = "employee_id")
    private Employee employee;

    public Transaction(){
        
    }

    public Transaction(Long id, Float amount, Boolean entry, String concept,Date updatedAt,
            Date createdAt, Enterprise enterprise, Employee employee) {
        this.id = id;
        this.amount = amount;
        this.entry = entry;
        this.concept = concept;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.enterprise = enterprise;
        this.employee = employee;

        if (!entry) {
            amount = amount * -1;
        }
    }
    
        
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Date getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Boolean getEntry() {
        return entry;
    }

    public void setEntry(Boolean entry) {
        this.entry = entry;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }


    public Enterprise getEnterprise() {
        return enterprise;
    }


    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


    public Employee getEmployee() {
        return employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}



