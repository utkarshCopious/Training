package com.clientmanagerapi.model;

/*
  @author Utkarsh Awasthi

 */

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ClientService")
public class Client {

    @Id
    @Column(unique = true)
    @NotBlank
    @Size(min = 13, message = "id should have atleast 13 characters") //for ensuring valid south african ID number
    private long id;

    @Column
    @NotBlank
    @Size(min = 2, message = "First Name should have atleast 2 characters")
    private String firstname;

    @Column
    @NotBlank
    @Size(min = 2, message = " Last Name should have atleast 2 characters")
    private String lastname;

    @Column(unique = true)
    private long phone;
    @Column
    private String address;

    public Client(){}

    public Client(long id, String firstname, String lastname, long phone, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFName() {
        return firstname;
    }

    public void setFName(String firstname) {
        this.firstname = firstname;
    }

    public String getLName() {
        return lastname;
    }

    public void setLName(String lastname) {
        this.lastname = lastname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Client id=" + id + ", name=" + firstname + "last name = " + lastname + ", phone=" + phone
                + ", salary=" + address + " ";
    }


}
