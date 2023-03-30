from django import forms
from .models import User


class UserFrom(forms.ModelForm):
    class Meta:
        model = User
        fields = ['id', 'email']


class AdressFrom(forms.ModelForm):
    class Meta:
        model = User
        fields = ['id', 'adresse', 'ville', 'etat', 'code Postal']


#############################
class InformationUserFrom(forms.ModelForm):
    class Meta:
        model = User
        fields = ['id', 'user Localization', 'phone Number', 'adresses Email', 'Otherlink']
