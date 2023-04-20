from django.db import models


# Create your models here.
class Address(models.Model):
    address = models.CharField(max_length=50)
    city = models.CharField(max_length=50)
    state = models.CharField(max_length=50)
    postal_code = models.CharField(max_length=50)

    def __init__(self, adresse_, ville_, etat_, codePostal_):
        self.adresse = adresse_
        self.ville = ville_
        self.etat = etat_
        self.codePostal = codePostal_


class Users(models.Model):
    name = models.CharField(max_length=50)
    lastName = models.CharField(max_length=50)
    emailUsers = models.EmailField()
    passwordUsers = models.CharField(max_length=50)

    def __init__(self, emailUsers_, passwordUsers_, name_, lastName_):
        self.name = name_
        self.lastName = lastName_
        self.emailUsers = emailUsers_
        self.passwordUsers = passwordUsers_


class Localization(models.Model):
    address = models.ForeignKey(Address, on_delete=models.CASCADE)

    def __init__(self, address_):
        self.address = address_


class InformationUser(models.Model):
    idUsers = models.ForeignKey(Users, on_delete=models.CASCADE)
    userLocalization = models.ForeignKey(Localization, on_delete=models.CASCADE)
    phoneNumber = models.CharField(max_length=50)
    adressesMail = models.CharField(max_length=50)
    other_link = models.CharField(max_length=50)
    images = models.ImageField(upload_to="InformationUser", blank=True, null=True)

    def __init__(self, userLocalization_, phoneNumber_, adressesMail_, other_link_, images_):
        self.userLocalization = userLocalization_
        self.phoneNumber = phoneNumber_
        self.adressesMail = adressesMail_
        self.other_link = other_link_
        self.images = images_
