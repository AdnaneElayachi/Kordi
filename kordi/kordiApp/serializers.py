from rest_framework import serializers
from .models import *


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = '__all__'


class AdressSerializer(serializers.ModelSerializer):
    class Meta:
        model = Adress
        fields = '__all__'


class LocalizationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Localization
        fields = '__all__'


class InformationUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = InformationUser
        fields = '__all__'
