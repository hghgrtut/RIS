from django.contrib.auth.forms import UserCreationForm
from django.http import HttpResponse, HttpResponseNotFound
from django.shortcuts import render
from django.urls import reverse_lazy
from django.views.generic import ListView, DetailView, CreateView

from .models import *


class Home(ListView):
    model = ProductModel
    template_name = 'Main/home.html'
    context_object_name = 'new_products'
    extra_context = {'title': 'Главная'}

    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        two_product = ProductModel.objects.all().order_by('time_create')[:2]
        context['two_product'] = two_product
        return context

    def get_queryset(self):
        return ProductModel.objects.filter(status=True).order_by('-time_create')[:8]



class AllProducts(ListView):
    model = ProductModel
    template_name = 'Main/all-products.html'
    context_object_name = 'products'
    extra_context = {'title': 'Все товары'}

    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        category = CategoryModel.objects.all()
        brand = BrandModel.objects.all()
        context['category'] = category
        context['brand'] = brand
        return context

    def get_queryset(self):
        return ProductModel.objects.filter(status=True)


class SingleProduct(DetailView):
    model = ProductModel
    template_name = 'Main/single-product.html'
    context_object_name = 'product'

    def get_context_data(self, *, object_list=None, **kwargs):
        context = super().get_context_data(**kwargs)
        other_products = ProductModel.objects.all()
        context['other_products'] = other_products
        return context

def about(request):
    return render(request, 'Main/about.html', {'title': 'О нас'})

def contact(request):
    return render(request, 'Main/contact.html', {'title': 'Контакты'})


def pageNotFound(request, exception):
    return HttpResponseNotFound("Error 404")
