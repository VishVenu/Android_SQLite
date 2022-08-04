package com.example.contactssqliteapplication;

public class UserModal {

    // variables for our name,
    // telephone number, email address and address.
    private String name;
    private String telephoneNumber;
    private String emailAddress;
    private String address;

    // creating getter methods
    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    // constructor
    public UserModal(String name, String telephoneNumber, String emailAddress, String address) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
