package org.kharitonov.springWeb.services;

import org.kharitonov.springWeb.dto.TaskDTO;
import org.kharitonov.springWeb.dto.factories.TaskDTOFactory;
import org.kharitonov.springWeb.entites.TaskEntity;
import org.kharitonov.springWeb.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> findAll() {
       return  taskRepository.findAll();
    }

    public TaskEntity save(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
        return taskEntity;
    }

    public TaskEntity findById(int id) {
        return taskRepository.findById(id);
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    public TaskEntity copyProperties(TaskEntity taskEntityFormDB, TaskEntity taskEntity) {
        taskEntityFormDB.setName(taskEntity.getName());
        taskEntityFormDB.setCreateAt(taskEntity.getCreateAt());
        taskEntityFormDB.setDescription(taskEntityFormDB.getDescription());
        return taskEntityFormDB;
    }

}
