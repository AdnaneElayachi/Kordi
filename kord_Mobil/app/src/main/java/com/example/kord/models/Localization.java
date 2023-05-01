package com.example.kord.models;

public class Localization {


    private  Address address;
     private int id;
     private static int count;

     public Localization(Address _adress){
          this.address=_adress;
          id=++count;

     }
     public Localization(int id,Address _adress){
          this.address=_adress;
          this.id =id;

     }

     public Address getAddress() {
          return address;
     }

     public void setAddress(Address adress) {
          this.address = adress;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }
}
