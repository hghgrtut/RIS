package com.kharitonov.taskTracker.controllers;

import com.kharitonov.taskTracker.contracts.ApiRouter;
import com.kharitonov.taskTracker.dtos.ProjectDTO;
import com.kharitonov.taskTracker.entites.ProjectEntity;
import com.kharitonov.taskTracker.entites.TaskStateEntity;
import com.kharitonov.taskTracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ApiRouter.ProjectRouter.BASE_URL)
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDTO> getAll() {
        return projectService.findAll();
    }

    @GetMapping(ApiRouter.ProjectRouter.FIND_BY_ID)
    public ProjectDTO getById(@PathVariable("id") Optional<Long> id) {
        return projectService.findById(id);
    }

    @PostMapping
    public ProjectDTO create(@RequestBody Optional<ProjectEntity> optionalProjectEntity) {
        return projectService.save(optionalProjectEntity);
    }

    @PutMapping(ApiRouter.ProjectRouter.UPDATE)
    public ProjectDTO update(@PathVariable("id") Optional<ProjectEntity> optionalProjectEntityFromDB,
                             @RequestBody Optional<ProjectEntity> optionalProjectEntity) {
        return projectService.update(optionalProjectEntityFromDB, optionalProjectEntity);
    }

    @PutMapping(ApiRouter.ProjectRouter.ADD_TASK_STATE)
    public ProjectDTO addTaskState(@PathVariable("projectId") Optional<ProjectEntity> optionalProjectEntity,
                                   @PathVariable("taskStateId")Optional<TaskStateEntity> optionalTaskStateEntity) {
        return projectService.addTaskState(optionalProjectEntity, optionalTaskStateEntity);
    }

    @PutMapping(ApiRouter.ProjectRouter.SWAP_TASK_STATE)
    public ProjectDTO swap(@PathVariable("projectId") Optional<ProjectEntity> optionalProjectEntity,
                           @PathVariable("taskStateTargetId") Optional<Long> optionalTaskStateTargetId,
                           @PathVariable("taskStateSourceId") Optional<Long> optionalTaskStateSourceId) {
       return projectService.swap(optionalProjectEntity, optionalTaskStateTargetId, optionalTaskStateSourceId);
    }

    @DeleteMapping(ApiRouter.ProjectRouter.DELETE)
    public void delete(@PathVariable("id") Optional<ProjectEntity> optionalProjectEntity) {
        projectService.deleteByObject(optionalProjectEntity);
    }
}
