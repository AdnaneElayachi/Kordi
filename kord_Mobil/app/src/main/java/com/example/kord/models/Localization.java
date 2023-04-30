package com.example.kord.models;

public class Localization {


     Address adress;

     public Localization(Address _adress){
          this.adress=_adress;

     } public Address getAdress() {
          return adress;
     }

     public void setAdress(Address adress) {
          this.adress = adress;
     }
}
