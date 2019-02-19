package com.lsc.model;

public class ContactModel {

    private long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String city;

    public ContactModel(long id, String firstName, String lastName, String telephone, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.city = city;
        this.id = id;
    }

    public ContactModel(){}

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

    @Override
    public String toString() {
        return "ContactModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
