from django.contrib import admin

from .models import *

class ProductModelAdmin(admin.ModelAdmin):
    list_display = ('id', 'title', 'slug', 'old_price', 'new_price', 'status', 'category', 'brand')
    list_display_links = ('id', 'title', 'slug')
    search_fields = ('title', 'description', 'category', 'brand')
    list_editable = ('old_price', 'new_price', 'status')
    list_filter = ('status', 'category', 'brand')
    prepopulated_fields = {'slug': ('title',)}

class CategoryModelAdmin(admin.ModelAdmin):
    list_display = ('id', 'title', 'slug')
    list_display_links = ('id', 'title')
    search_fields = ('title',)
    prepopulated_fields = {'slug': ('title',)}

class BrandModelAdmin(admin.ModelAdmin):
    list_display = ('id', 'title', 'slug')
    list_display_links = ('id', 'title')
    search_fields = ('title',)
    prepopulated_fields = {'slug': ('title',)}

admin.site.register(ProductModel, ProductModelAdmin)
admin.site.register(CategoryModel, CategoryModelAdmin)
admin.site.register(BrandModel, BrandModelAdmin)