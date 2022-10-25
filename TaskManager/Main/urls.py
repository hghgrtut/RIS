from django.urls import path
from .views import *

urlpatterns = [
    path('', ActiveTask.as_view(), name='activeTask'),
    path('didTask/', DidTask.as_view(), name='didTask'),
    path('allTask/', AllTask.as_view(), name='allTask'),
    path('addTask/', AddTask.as_view(), name='addTask'),
    path('ready/<int:task_id>', readyTask, name='readyTask'),
    path('activate/<int:task_id>', activateTask, name='activateTask'),
    path('update/<int:pk>', UpdateTask.as_view(), name='updateTask'),
    path('delete/<int:pk>', DeleteTask.as_view(), name='deleteTask')
]
