from django.shortcuts import render, redirect, get_object_or_404

from .forms import UserFrom, AdressFrom, InformationUserFrom
from .models import User, InformationUser, Adress
from rest_framework.decorators import api_view
from rest_framework.response import Response
from .serializers import *

"""
# Create your views here.

def listUser(request):
    for i in range(10):
        u = User(None)
        u.save()
    d = User.objects.all()
    return render(request, 'index.html', {'data': d})


def create_user(request):
    if request.method == 'Post':
        form = UserFrom(request.POST)
        if form.is_valid():
            form.save()
            return redirect('listPatients')
    else:
        form = UserFrom()
    return render(request, '', {'from': form})


def update_user(request, pk):
    user = get_object_or_404(User, pk=pk)
    if request.method == 'POST':
        form = UserFrom(request.POST, instance=user)
        if form.is_valid():
            form.save()
            return redirect('listUser')
    else:
        form = UserFrom(instance=user)
    return render(request, '', {'form': form, 'patient': user})


def delete_user(request, pk):
    users = get_object_or_404(User, pk=pk)
    users.delete()

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
        form = AdressFrom(request.POST)
        if form.is_valid():
            form.save()
            return redirect('')
    else:
        form = AdressFrom()
    return render(request, '', {'from': form})


def update_Adress(request, pk):
    adress = get_object_or_404(User, pk=pk)
    if request.method == 'POST':
        form = AdressFrom(request.POST, instance=adress)
        if form.is_valid():
            form.save()
            return redirect('listAdress')
    else:
        form = AdressFrom(instance=adress)
    return render(request, '', {'form': form, 'adress': adress})


def delete_adress(request, pk):
    adress = get_object_or_404(User, pk=pk)
    adress.delete()

    return redirect('')


################################################
def listInformationUser(request):
    for i in range(10):
        info = InformationUser(None)
        info.save()
    d = Adress.objects.all()
    return render(request, '', {'data': d})


def create_Adress(request):
    if request.method == 'Post':
        form = InformationUserFrom(request.POST)
        if form.is_valid():
            form.save()
            return redirect('')
    else:
        form = InformationUserFrom()
    return render(request, '', {'from': form})


def update_InformationUser(request, pk):
    informationUser = get_object_or_404(User, pk=pk)
    if request.method == 'POST':
        form = InformationUserFrom(request.POST, instance=informationUser)
        if form.is_valid():
            form.save()
            return redirect('listInformationUser')
    else:
        form = AdressFrom(instance=informationUser)
    return render(request, '', {'form': form, 'update_InformationUser': informationUser})


def delete_informationUser(request, pk):
    adress = get_object_or_404(User, pk=pk)
    adress.delete()

    return redirect('')
"""


@api_view(['GET'])
def allUsers(request):
    users = User.objects.all()
    serialization = UserSerializer(users, many=True)
    return Response(serialization.data)


@api_view(['GET'])
def getUser(request, id):
    user = User.objects.get(id=id)
    serializer = UserSerializer(user)
    return Response(serializer.data)


@api_view(['POST'])
def addUsers(request):
    serializer = UserSerializer(data=request.data, many=True)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)


@api_view(['PUT'])
def updateUsers(request, id):
    user = User.objects.get(id=id)
    serializer = UserSerializer(data=request.data, many=True)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)


api_view(['DELET'])


def DeletUsers(request, id):
    user = User.objects.get(id=id)
    user.delete()
    return Response(" ")
