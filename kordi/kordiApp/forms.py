from django import forms
from .models import Users


class UserFrom(forms.ModelForm):
    class Meta:
        model = Users
        fields = ['id', 'email']


class AdressFrom(forms.ModelForm):
    class Meta:
        model = Users
        fields = ['id', 'adresse', 'ville', 'etat', 'code Postal']


#############################
class InformationUserFrom(forms.ModelForm):
    class Meta:
        model = Users
        fields = ['id', 'user Localization', 'phone Number', 'adresses Email', 'Otherlink']
