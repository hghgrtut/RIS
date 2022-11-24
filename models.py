from django.db import models
from django.urls import reverse


class ProductModel(models.Model):
    title = models.CharField(max_length=255, verbose_name='Название')
    slug = models.SlugField(max_length=100, unique=True, db_index=True, verbose_name='URL')
    description = models.TextField(verbose_name='Описание')
    old_price = models.FloatField(verbose_name='Старая цена')
    new_price = models.FloatField(verbose_name='Новая цена')
    photo = models.ImageField(upload_to="products_image", verbose_name='Фото')
    quantity = models.PositiveIntegerField(verbose_name='Количество')
    time_create = models.DateTimeField(auto_now_add=True, verbose_name='Дата создание')
    status = models.BooleanField(default=True, verbose_name='Наличие')
    category = models.ForeignKey('CategoryModel', on_delete=models.PROTECT, verbose_name='Категория')
    brand = models.ForeignKey('BrandModel', on_delete=models.PROTECT, verbose_name='Бренд')

    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return reverse('single_product', kwargs={'slug': self.slug})

    class Meta:
        verbose_name = 'Товар'
        verbose_name_plural = 'Товары'


class CategoryModel(models.Model):
    title = models.CharField(max_length=100, db_index=True, verbose_name='Категория')
    slug = models.SlugField(max_length=100, unique=True, db_index=True, verbose_name='URL')

    def __str__(self):
        return self.title

    class Meta:
        verbose_name = 'Категория'
        verbose_name_plural = 'Категории'


class BrandModel(models.Model):
    title = models.CharField(max_length=100, db_index=True, verbose_name='Бренд')
    slug = models.SlugField(max_length=100, unique=True, db_index=True, verbose_name='URL')

    def __str__(self):
        return self.title

    class Meta:
        verbose_name = 'Бренд'
        verbose_name_plural = 'Бренды'