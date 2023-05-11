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
        fields = ['address', 'city', 'state', 'postal_code']
        widgets = {
            'address': forms.TextInput(attrs={'class': 'form-control'}),
            'city': forms.TextInput(attrs={'class': 'form-control'}),
            'state': forms.TextInput(attrs={'class': 'form-control'}),
            'postal_code': forms.TextInput(attrs={'class': 'form-control'}),

        }


#############################

class InformationUserFrom(forms.ModelForm):
    class Meta:
        model = InformationUser
        fields = '__all__'
        widgets = {
            'userLocalization': forms.TextInput(attrs={'class': 'form-control'}),
            'phoneNumber': forms.TextInput(attrs={'class': 'form-control'}),
            'adressesMail': forms.TextInput(attrs={'class': 'form-control'}),
            'other_link': forms.TextInput(attrs={'class': 'form-control'}),
            'images': forms.TextInput(attrs={'class': 'form-control'}),

        }
