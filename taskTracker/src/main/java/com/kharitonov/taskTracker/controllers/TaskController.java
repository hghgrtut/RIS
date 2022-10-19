package com.kharitonov.taskTracker.controllers;

import com.kharitonov.taskTracker.contracts.ApiRouter;
import com.kharitonov.taskTracker.dtos.TaskDTO;
import com.kharitonov.taskTracker.entites.TaskEntity;
import com.kharitonov.taskTracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = ApiRouter.TaskRouter.BASE_URL)
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getAll() {
        return taskService.findAll();
    }

    @GetMapping(ApiRouter.TaskRouter.FIND_BY_ID)
    public TaskDTO getById(@PathVariable("id") Optional<Long> id) {
        return taskService.findById(id);
    }

    @PostMapping
    public TaskDTO create(@RequestBody Optional<TaskEntity> optionalTaskEntity) {
        return taskService.save(optionalTaskEntity);
    }

    @PutMapping(ApiRouter.TaskRouter.UPDATE)
    public TaskDTO update(@PathVariable("id") Optional<TaskEntity> optionalTaskEntityFromDB,
                              @RequestBody Optional<TaskEntity> optionalTaskEntity) {
        return taskService.update(optionalTaskEntityFromDB, optionalTaskEntity);
    }

    @DeleteMapping(ApiRouter.TaskRouter.DELETE)
    public void delete(@PathVariable("id") Optional<Long> id) {
        taskService.deleteById(id);
    }

}
