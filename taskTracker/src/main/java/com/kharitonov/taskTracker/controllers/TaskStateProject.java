package com.kharitonov.taskTracker.controllers;

import com.kharitonov.taskTracker.contracts.ApiRouter;
import com.kharitonov.taskTracker.dtos.TaskStateDTO;
import com.kharitonov.taskTracker.entites.TaskEntity;
import com.kharitonov.taskTracker.entites.TaskStateEntity;
import com.kharitonov.taskTracker.services.TaskStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ApiRouter.TaskStateRouter.BASE_URL)
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TaskStateProject {

    private final TaskStateService taskStateService;

    @Autowired
    public TaskStateProject(TaskStateService taskStateService) {
        this.taskStateService = taskStateService;
    }

    @GetMapping
    public List<TaskStateDTO> getAll() {
        return taskStateService.findAll();
    }

    @GetMapping(ApiRouter.TaskStateRouter.FIND_BY_ID)
    public TaskStateDTO getById(@PathVariable("id") Optional<Long> optionalId) {
        return taskStateService.findById(optionalId);
    }

    @PostMapping
    public TaskStateDTO create(@RequestBody Optional<TaskStateEntity> optionalTaskStateEntity) {
        return taskStateService.save(optionalTaskStateEntity);
    }

    @PutMapping(ApiRouter.TaskStateRouter.UPDATE)
    public TaskStateDTO update(@PathVariable("id") Optional<TaskStateEntity> optionalTaskStateEntityFromDB,
                               @RequestBody Optional<TaskStateEntity> optionalTaskStateEntity) {
       return taskStateService.update(optionalTaskStateEntityFromDB, optionalTaskStateEntity);
    }

    @PutMapping(ApiRouter.TaskStateRouter.ADD_TASK)
    public TaskStateDTO addTask(@PathVariable("taskStateId") Optional<TaskStateEntity> optionalTaskStateEntityFromDB,
                                @PathVariable("taskId") Optional<TaskEntity> optionalTaskEntity) {
         return taskStateService.addTask(optionalTaskStateEntityFromDB, optionalTaskEntity);
    }

    @DeleteMapping(ApiRouter.TaskStateRouter.DELETE)
    public void delete(@PathVariable("id") Optional<Long> optionalId) {
        taskStateService.deleteById(optionalId);
    }

}
