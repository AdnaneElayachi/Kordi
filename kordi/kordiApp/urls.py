from django.urls import path
from kordi.kordiApp.views import user_login

urlpatterns = [
    path('login/', user_login, name='login')
]
