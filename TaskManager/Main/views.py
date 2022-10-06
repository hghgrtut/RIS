from django.http import HttpResponseNotFound
from django.shortcuts import render, redirect
from django.views.generic import ListView, UpdateView, DeleteView, FormView, CreateView

from .models import Task
from .forms import TaskForm

#python manage.py runserver --insecure

class ActiveTask(ListView):
    model = Task
    template_name = 'Main/index.html'
    extra_context = {'title': 'Активные задачи', 'page': 'activeTask'}
    context_object_name = 'tasks'

    def get_queryset(self):
        return Task.objects.filter(done=False)


class DidTask(ListView):
    model = Task
    template_name = 'Main/index.html'
    extra_context = {'title': 'Выполненные задачи', 'page': 'didTask'}
    context_object_name = 'tasks'

    def get_queryset(self):
        return Task.objects.filter(done=True).order_by('-time_update')


class AllTask(ListView):
    model = Task
    template_name = 'Main/index.html'
    extra_context = {'title': 'Все задачи', 'page': 'allTask'}
    context_object_name = 'tasks'
    ordering = ['-time_update']


class AddTask(CreateView):
    template_name = 'Main/add.html'
    form_class = TaskForm
    success_url = '/'
    extra_context = {'title': 'Добавить задачу', 'page': 'addTask'}


# Кнопки - выполнено, активировать, редактировать, удалить
def readyTask(request, task_id):
    task = Task.objects.get(pk=task_id)
    task.done = True
    task.save()
    return redirect('didTask')


# class ReadyTask(UpdateView):
#     model = Task


def activateTask(request, task_id):
    task = Task.objects.get(pk=task_id)
    task.done = False
    task.save()
    return redirect('activeTask')


class DeleteTask(DeleteView):
    model = Task
    success_url = '/'
    template_name = 'Main/delete.html'
    extra_context = {'page': 'deleteTask'}


class UpdateTask(UpdateView):
    model = Task
    template_name = 'Main/add.html'
    form_class = TaskForm
    success_url = '/'
    extra_context = {'page': 'updateTask'}