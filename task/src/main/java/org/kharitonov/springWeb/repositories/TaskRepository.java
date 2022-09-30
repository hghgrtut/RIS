package org.kharitonov.springWeb.repositories;

import org.kharitonov.springWeb.annotations.IdAnnotation;
import org.kharitonov.springWeb.entites.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<TaskEntity> tasks = new ArrayList<>();
    private final IdAnnotation idAnnotation;

    @Autowired
    public TaskRepository(IdAnnotation idAnnotation) {
        this.idAnnotation = idAnnotation;
    }

    public List<TaskEntity> findAll() {
        return tasks;
    }

    public TaskEntity findById(int id) {
       return tasks.stream()
               .filter(task -> task.getId() == id)
               .findAny()
               .orElseThrow(NullPointerException::new);
    }

    public void save(TaskEntity task) {
        idAnnotation.setFieldId(task);
        tasks.add(task);
    }

    public void deleteById(int id) {
        TaskEntity taskEntity = tasks.stream()
                .filter(task -> task.getId() == id)
                .findAny()
                .orElseThrow(NullPointerException::new);
        tasks.remove(taskEntity);
    }

}
