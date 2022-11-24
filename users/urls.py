from django.urls import path, include

from .views import *

urlpatterns = [
    path('signup/', SignUp.as_view(), name="signup"),
    path('cart/', cart, name='cart'),
    path('wishlist/', wishlist, name='wishlist')
]