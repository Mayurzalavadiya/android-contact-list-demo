package com.example.contactlist;

public class ContactModel {

    private String userName;
    private String contactNumber;

    public ContactModel(String userName, String contactNumber) {
        this.userName = userName;
        this.contactNumber = contactNumber;
    }

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getContactNumber() {return contactNumber;}

    public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}
}
