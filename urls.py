from django.urls import path

from .views import *

urlpatterns = [
    path('', Home.as_view(), name='home'),
    path('products/', AllProducts.as_view(), name='all_products'),
    path('contact/', contact, name='contact'),
    path('about/', about, name='about'),
    path('product/<slug:slug>', SingleProduct.as_view(), name='single_product'),
]