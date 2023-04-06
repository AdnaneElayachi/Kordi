from django.db import models


# Create your models here.
class Adress(models.Model):
    adresse = models.TextField()
    ville = models.TextField()
    etat = models.TextField()
    codePostal = models.TextField()


class Users(models.Model):
    emailUsers = models.EmailField()
    passwordUsers = models.TextField()


class Localization(models.Model):
    address = models.ForeignKey(Adress, on_delete=models.CASCADE)


class InformationUser(models.Model):
    userLocalization = models.ForeignKey(Localization, on_delete=models.CASCADE)
    phoneNumber = models.TextField()
    adressesMail = models.TextField()
    Other_link = models.TextField()
    images = models.ImageField(upload_to="InformationUser", blank=True , null=True)



