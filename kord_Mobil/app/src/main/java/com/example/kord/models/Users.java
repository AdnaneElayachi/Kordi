package com.example.kord.models;

public class Users {

    String name;
    String lastName;
    String emailUsers;
    String paswordUsers;
   public  Users(String _name,String _lastName,String _emailUsers,String _paswordUsers)
    {
        this.name=_name;
        this.lastName=_lastName;
        this.emailUsers=_emailUsers;
        this.paswordUsers=_paswordUsers;

    }
    public String getName() {
        return name;
    }

    public String getEmailUsers() {
        return emailUsers;
    }

    public void setEmailUsers(String emailUsers) {
        this.emailUsers = emailUsers;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPaswordUsers() {
        return paswordUsers;
    }

    public void setPaswordUsers(String paswordUsers) {
        this.paswordUsers = paswordUsers;
    }

    public void setName(String name) {
        this.name = name;
    }
}
