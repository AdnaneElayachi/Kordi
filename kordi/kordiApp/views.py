from django.http import HttpResponse
from django.shortcuts import render, redirect, get_object_or_404

from . import forms

from .serializers import *
from django.contrib.auth import authenticate, login, logout
from django.shortcuts import render, redirect
import qrcode


def listUser(request):

    d = Users.objects.all()
    return render(request, 'index.html', {'data': d})


def create_user(request):
    if request.method == 'Post':
        form = forms.UserFrom(request.POST)
        if form.is_valid():
            form.save()
            return redirect('listPatients')
    else:
        form = forms.UserFrom()
    return render(request, '', {'from': form})


def update_user(request, pk):
    user = get_object_or_404(Users, pk=pk)
    if request.method == 'POST':
        form = forms.UserFrom(request.POST, instance=user)
        if form.is_valid():
            form.save()
            return redirect('listUser')
    else:
        form = forms.UserFrom(instance=user)
    return render(request, '', {'form': form, 'patient': user})


def delete_user(request, pk):
    users = get_object_or_404(Users, pk=pk)
    users.delete()

    return redirect('')

################################################
def user_login(request):
    if request.method == 'POST':
        emailUsers = request.POST['emailUsers']
        passwordUsers = request.POST['passwordUsers']
        user = authenticate(request, emailUsers=emailUsers, passwordUsers=passwordUsers)
        if user is not None:
            login(request, user)
            return redirect('home')
        else:

            return render(request, '', {'error': 'Invalid credentials'})
    else:
        return render(request, '')


def user_logout(request):
    logout(request)
    # home
    return redirect('')


################################################
def listAdress(request):
    for i in range(10):
        a = Adress(None)
        a.save()
    d = Adress.objects.all()
    return render(request, '', {'data': d})


def create_Adress(request):
    if request.method == 'Post':
        form = forms.AdressFrom(request.POST)
        if form.is_valid():
            form.save()
            return redirect('')
    else:
        form = forms.AdressFrom()
    return render(request, '', {'from': form})


def update_Adress(request, pk):
    adress = get_object_or_404(Users, pk=pk)
    if request.method == 'POST':
        form = forms.AdressFrom(request.POST, instance=adress)
        if form.is_valid():
            form.save()
            return redirect('listAdress')
    else:
        form = forms.AdressFrom(instance=adress)
    return render(request, '', {'form': form, 'adress': adress})



################################################
def listInformationUser(request):
    for i in range(10):
        info = InformationUser(None)
        info.save()
    d = Adress.objects.all()
    return render(request, '', {'data': d})


def create_InformationUser(request):
    if request.method == 'Post':
        form = forms.InformationUserFrom(request.POST)
        if form.is_valid():
            form.save()
            return redirect('')
    else:
        form = forms.InformationUserFrom()
    return render(request, '', {'from': form})

def update_InformationUser(request, pk):
    informationUser = get_object_or_404(Users, pk=pk)
    if request.method == 'POST':
        form = forms.InformationUserFrom(request.POST, instance=informationUser)
        if form.is_valid():
            form.save()
            return redirect('listInformationUser')
    else:
        form = forms.AdressFrom(instance=informationUser)
    return render(request, '', {'form': form, 'update_InformationUser': informationUser})



def QR_Code_informationUser(request, pk):
    information_user = get_object_or_404(Users, pk=pk)
    data = f"{information_user.userLocalization}, {information_user.phoneNumber}, {information_user.other_link}, {information_user.images}"
    qr = qrcode.QRCode(version=1, box_size=10, border=5)
    qr.add_data(data)
    qr.make(fit=True)
    img = qr.make_image(fill_color="black", back_color="white")
    response = HttpResponse(content_type="image/png")
    img.save(response, "PNG")
    return response


def liens_informationUser(request, pk):
    information_user = get_object_or_404(Users, pk=pk)
    data = f"{information_user.userLocalization}, {information_user.phoneNumber}, {information_user.other_link}, {information_user.images}"

    return data
