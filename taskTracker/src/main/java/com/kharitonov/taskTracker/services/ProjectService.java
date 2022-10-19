package com.kharitonov.taskTracker.services;

import com.kharitonov.taskTracker.dtos.ProjectDTO;
import com.kharitonov.taskTracker.dtos.factories.ProjectDTOFactory;
import com.kharitonov.taskTracker.entites.ProjectEntity;
import com.kharitonov.taskTracker.entites.TaskStateEntity;
import com.kharitonov.taskTracker.exceptions.BadRequestException;
import com.kharitonov.taskTracker.exceptions.NotFoundException;
import com.kharitonov.taskTracker.repositories.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDTO> findAll() {
         return projectRepository.findAll()
                 .stream()
                 .map(projectEntity -> new ProjectDTOFactory().toProjectDTO(projectEntity))
                 .toList();
    }

    public ProjectDTO findById(Optional<Long> optionalId) {
        Long id = optionalId.orElseThrow(BadRequestException::new);
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(NotFoundException::new);
        return new ProjectDTOFactory().toProjectDTO(projectEntity);
    }

    public ProjectDTO findByName(String name) {
        if(name.trim().isEmpty()) {
            throw new BadRequestException("Name is empty");
        }
        Optional<ProjectEntity> projectEntity = projectRepository.findByNameIgnoreCase(name);

        return new ProjectDTOFactory().toProjectDTO(projectEntity.get());
    }

    public ProjectDTO save(Optional<ProjectEntity> projectEntity) {
        ProjectEntity project = projectEntity.orElseThrow(BadRequestException::new);
        return new ProjectDTOFactory().toProjectDTO(projectRepository.save(project));
    }

    public ProjectDTO update(Optional<ProjectEntity> optionalProjectEntityFromDB,
                             Optional<ProjectEntity> optionalProjectEntity) {
        if(optionalProjectEntityFromDB.isEmpty() || optionalProjectEntity.isEmpty()) {
            throw new BadRequestException("Object is not found.");
        }
        BeanUtils.copyProperties(optionalProjectEntity, optionalProjectEntityFromDB, "id");
        return save(optionalProjectEntityFromDB);
    }

    public ProjectDTO swap(Optional<ProjectEntity> optionalProjectEntity,
                           Optional<Long> optionalIdTarget, Optional<Long> optionalIdSource) {
        ProjectEntity projectEntity = optionalProjectEntity.orElseThrow(NotFoundException::new);
        if(optionalIdTarget.isEmpty() || optionalIdSource.isEmpty()) {
            throw new BadRequestException();
        }

        int taskStateTargetPosition = getTaskStatePosition(optionalProjectEntity, optionalIdTarget);
        int taskStateSourcePosition = getTaskStatePosition(optionalProjectEntity, optionalIdSource);

        swapPosition(projectEntity, taskStateTargetPosition, taskStateSourcePosition);

        swapPosition(projectEntity, taskStateSourcePosition, taskStateTargetPosition);

        return new ProjectDTOFactory().toProjectDTO(projectEntity);
    }



    public ProjectDTO addTaskState(Optional<ProjectEntity> projectEntity, Optional<TaskStateEntity> taskStateEntity) {
        if(projectEntity.isEmpty() || taskStateEntity.isEmpty()) {
            throw new NotFoundException("Object was not found");
        }

        ProjectEntity project = projectEntity.get();
        TaskStateEntity taskState = taskStateEntity.get();
        taskState.setPosition(project.getTaskStates().size());
        project.getTaskStates().add(taskState);

        return new ProjectDTOFactory().toProjectDTO(project);
    }

    public void deleteByObject(Optional<ProjectEntity> optionalProjectEntity) {
        projectRepository.delete(optionalProjectEntity.orElseThrow(BadRequestException::new));
    }

    private int getTaskStatePosition(Optional<ProjectEntity> optionalProjectEntity, Optional<Long> optionalTaskStateId) {
        ProjectEntity projectEntity = optionalProjectEntity.orElseThrow(NotFoundException::new);
        return projectEntity.getTaskStates().stream()
                .filter(taskStateEntity -> taskStateEntity.getId().equals(optionalTaskStateId.get()))
                .findFirst()
                .orElseThrow(BadRequestException::new)
                .getPosition();
    }

    private void swapPosition(ProjectEntity projectEntity, int taskStateTargetPosition, int taskStateSourcePosition) {
        projectEntity.getTaskStates().stream()
                .filter(taskStateEntity -> taskStateEntity.getPosition() == taskStateTargetPosition)
                .findFirst()
                .orElseThrow(NotFoundException::new)
                .setPosition(taskStateSourcePosition);
    }

}

