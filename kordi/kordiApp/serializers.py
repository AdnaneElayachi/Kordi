from rest_framework import serializers
from .models import *


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = Users
        fields = '__all__'


class AdressSerializer(serializers.ModelSerializer):
    class Meta:
        model = Address
        fields = '__all__'


class LocalizationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Localization
        fields = '__all__'


class InformationUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = InformationUser
        fields = '__all__'
