package com.lsc.entity;

import javax.persistence.*;

@Entity
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name ="telephone")
    private String telephone;
    @Column(name = "city")
    private String city;

    public Contact(long id, String firstName, String lastName, String telephone, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.city = city;
        this.id = id;
    }

    public Contact(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
