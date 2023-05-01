package com.example.kord.models;

public class Address {
    private int id;
    private String rue;
    private String city;
    private  String state;
    private String postal_code;
    private static int count;

   public  Address(String _address, String _city,String _state, String _postal_code){
        this.rue=_address;
       this.city=_city;
       this.state=_state;
       this.postal_code=_postal_code;
       this.id=++count;

    }


    public  Address(int id ,String _address, String _city,String _state, String _postal_code){
        this.rue=_address;
        this.city=_city;
        this.state=_state;
        this.postal_code=_postal_code;
        this.id=id;

    }

    public Address(String city) {
        this.city = city;
    }



    public String getrue() {
        return rue;
    }

    public String getCity() {
        return city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getState() {
        return state;
    }

    public void setrue(String address) {
        this.rue = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
