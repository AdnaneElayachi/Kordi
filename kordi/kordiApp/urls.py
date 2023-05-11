from django.urls import path
from .views import *

urlpatterns = [
    path('home/', homePage, name='Home'),
    path('login/', user_login, name='login'),
    path('register/', register, name='register'),



]
