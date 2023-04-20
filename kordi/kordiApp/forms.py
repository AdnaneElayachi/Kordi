from django import forms
from .models import *


class UserForm(forms.ModelForm):
    class Meta:
        model = Users
        fields = ['name', 'lastName', 'emailUsers', 'passwordUsers']
        widgets = {
            'name': forms.TextInput(attrs={'class': 'form-control'}),
            'lastName': forms.TextInput(attrs={'class': 'form-control'}),
            'emailUsers': forms.TextInput(attrs={'class': 'form-control'}),
            'passwordUsers': forms.TextInput(attrs={'class': 'form-control'}),

        }

    def save(self, commit=True):
        user = super(UserForm, self).save(commit=False)
        user.email = self.cleaned_data['email']
        if commit:
            user.save()
        return user


class AdressFrom(forms.ModelForm):
    class Meta:
        model = Address
        fields = ['adresse', 'ville', 'etat', 'code Postal']
        widgets = {
            'adresse': forms.TextInput(attrs={'class': 'form-control'}),
            'ville': forms.TextInput(attrs={'class': 'form-control'}),
            'etat': forms.TextInput(attrs={'class': 'form-control'}),
            'codePostal': forms.TextInput(attrs={'class': 'form-control'}),

        }


#############################
class InformationUserFrom(forms.ModelForm):
    class Meta:
        model = InformationUser
        fields = ['user Localization', 'phone Number', 'adresses Email', 'Otherlink']
        widgets = {
            'userLocalization': forms.TextInput(attrs={'class': 'form-control'}),
            'phoneNumber': forms.TextInput(attrs={'class': 'form-control'}),
            'adressesEmail': forms.TextInput(attrs={'class': 'form-control'}),
            'codeOtherlink': forms.TextInput(attrs={'class': 'form-control'}),

        }
