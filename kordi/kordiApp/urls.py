from django.urls import path
from .views import *

urlpatterns = [
    path('home/', homePage, name='Home'),
    path('login/', user_login, name='login'),
    path('registre/', user_login, name='registre')


]
