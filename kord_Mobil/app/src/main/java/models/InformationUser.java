package models;

public class InformationUser {
    Users user;
    Localization userLocalization;
    long phoneNumber;
    String  adressesMail;
    String  other_link;
    byte  images;
    public InformationUser(Users _user, Localization _userLocalization,long _phoneNumber,String  _adressesMail, String  _other_link,byte _images)
    {
        this.user=_user;
        this.userLocalization=_userLocalization;
        this.phoneNumber=_phoneNumber;
        this.adressesMail=_adressesMail;
        this.other_link=_other_link;
        this.images=_images;

    }

}
