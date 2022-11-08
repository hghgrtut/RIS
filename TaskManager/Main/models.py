from django.db import models
from django.urls import reverse


class Task(models.Model):
    title = models.CharField(max_length=255)
    task = models.TextField()
    time_create = models.DateTimeField(auto_now_add=True)
    time_update = models.DateTimeField(auto_now=True)
    done = models.BooleanField(default=False)

    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return f'/update/{self.pk}'  # reverse('updateTask', kwargs={'task_id': self.pk})

    class Meta:
        verbose_name = 'Задача'
        verbose_name_plural = 'Задачи'
        #ordering = ['-id']
