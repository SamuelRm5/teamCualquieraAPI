package com.mintic.teamCualquiera.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@SecondaryTable( name = "profile", pkJoinColumns = @PrimaryKeyJoinColumn(name = "profile_id") )
public class Employee {
    
    // El id es el profile ID
    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @Column(unique = true)
    private String email;

    @Column(name = "updateat", nullable = true)
    private Date updatedAt;

    @Column(name = "createdat")
    private Date createdAt;

    @Column(name = "role")
    private enum_RoleName role;

    @Column(name = "image", table = "profile", nullable = true)
    private String image;

    @Column(name = "phone", table = "profile", nullable = true)
    private String phone;

    @ManyToOne
    @JoinColumn( name = "enterprise", referencedColumnName = "id" )
    private Enterprise enterprise;

    public Employee(){
        
    }

    public Employee(String employeeId, String email, Date createdAt, enum_RoleName role, String image, String phone,
            Enterprise enterprise) {
        this.employeeId = employeeId;
        this.email = email;
        this.createdAt = createdAt;
        this.role = role;
        this.image = image;
        this.phone = phone;
        this.enterprise = enterprise;
    }

    public String getEmployeeId() {
        return employeeId;
    }



    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
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



    public enum_RoleName getRole() {
        return role;
    }



    public void setRole(enum_RoleName role) {
        this.role = role;
    }



    public String getImage() {
        return image;
    }



    public void setImage(String image) {
        this.image = image;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Enterprise getEnterprise() {
        return enterprise;
    }



    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    

}
