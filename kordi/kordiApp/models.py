from django.db import models


# Create your models here.
class Adress(models.Model):
    adresse = models.TextField()
    ville = models.TextField()
    etat = models.TextField()
    codePostal = models.TextField()
    def __init__(self,adresse_,ville_,etat_,codePostal_):
        self.adresse=adresse_
        self.ville=ville_
        self.etat=etat_
        self.codePostal=codePostal_


class Users(models.Model):
    emailUsers = models.EmailField()
    passwordUsers = models.TextField()
    def __init__(self,emailUsers_,passwordUsers_):
        self.emailUsers=emailUsers_
        self.passwordUsers=passwordUsers_


class Localization(models.Model):
    address = models.ForeignKey(Adress, on_delete=models.CASCADE)
    def __init__(self,address_):
        self.address=address_

class InformationUser(models.Model):
    idUsers=models.ForeignKey(Users, on_delete=models.CASCADE)
    userLocalization = models.ForeignKey(Localization, on_delete=models.CASCADE)
    phoneNumber = models.TextField()
    adressesMail = models.TextField()
    other_link = models.TextField()
    images = models.ImageField(upload_to="InformationUser", blank=True , null=True)

    def __init__(self,userLocalization_,phoneNumber_,adressesMail_,other_link_,images_):
        self.userLocalization=userLocalization_
        self.phoneNumber=phoneNumber_
        self.adressesMail=adressesMail_
        self.other_link=other_link_
        self.images=images_



