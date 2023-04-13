from django import forms
from .models import *


class UserFrom(forms.ModelForm):
    class Meta:
        model = Users
        fields = ['id', 'email']

        def save(self, commit=True):
            user = super(UserFrom, self).save(commit=False)
            user.email = self.cleaned_data['email']
            if commit:
                user.save()


class AdressFrom(forms.ModelForm):
    class Meta:
        model = Address
        fields = ['id', 'adresse', 'ville', 'etat', 'code Postal']


#############################
class InformationUserFrom(forms.ModelForm):
    class Meta:
        model = InformationUser
        fields = ['id', 'user Localization', 'phone Number', 'adresses Email', 'Otherlink']
