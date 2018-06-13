package com.jawnek.datamodel;

import java.util.Objects;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNr;

    public Contact(String firstName, String lastName, String phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void editContact(String firstName, String lastName, String phoneNr){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getLastName().equals(((Contact)obj).getLastName())){
            return this.getFirstName().equals(((Contact)obj).getFirstName());
        }

        return this.getLastName().equals(((Contact)obj).getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
