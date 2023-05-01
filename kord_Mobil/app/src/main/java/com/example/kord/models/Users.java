package com.example.kord.models;

public class Users {

    private String name;
    private String lastName;
    private String emailUsers;
    private  String paswordUsers;
    private int id;
    private static int count;
   public  Users(String _name,String _lastName,String _emailUsers,String _paswordUsers)
    {
        this.name=_name;
        this.lastName=_lastName;
        this.emailUsers=_emailUsers;
        this.paswordUsers=_paswordUsers;
        this.id=++count;

    }

    public  Users(int id ,String _name,String _lastName,String _emailUsers,String _paswordUsers)
    {
        this.name=_name;
        this.lastName=_lastName;
        this.emailUsers=_emailUsers;
        this.paswordUsers=_paswordUsers;
        this.id=id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
