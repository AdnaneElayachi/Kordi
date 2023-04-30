package com.example.kord.models;
public class InformationUser {
    private Users user;
    private  Localization userLocalization;
    long phoneNumber;

    private  String  other_link;
    private  byte  images;
    private int id;
    private static int count;



    public InformationUser(Users _user, Localization _userLocalization,long _phoneNumber, String  _other_link,byte _images)
    {
        this.user=_user;
        this.userLocalization=_userLocalization;
        this.phoneNumber=_phoneNumber;

        this.other_link=_other_link;
        this.images=_images;
        this.id=++count;


    }
    public InformationUser(int id,Users _user, Localization _userLocalization,long _phoneNumber, String  _other_link,byte _images)
    {
        this.user=_user;
        this.userLocalization=_userLocalization;
        this.phoneNumber=_phoneNumber;

        this.other_link=_other_link;
        this.images=_images;
        this.id=id;
    }

    public String getOther_link() {
        return other_link;
    }

    public Users getUser() {
        return user;
    }
    public Localization getUserLocalization() {
        return userLocalization;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public byte getImages() {
        return images;
    }


    public void setUser(Users user) {
        this.user = user;
    }

    public void setImages(byte images) {
        this.images = images;
    }

    public void setOther_link(String other_link) {
        this.other_link = other_link;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserLocalization(Localization userLocalization) {
        this.userLocalization = userLocalization;
    }
}
