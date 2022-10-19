package com.kharitonov.taskTracker.dtos.factories;

import com.kharitonov.taskTracker.dtos.ProjectDTO;
import com.kharitonov.taskTracker.entites.ProjectEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectDTOFactory {

    public ProjectDTO toProjectDTO(ProjectEntity projectEntity) {
        return ProjectDTO.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .createAt(projectEntity.getCreateAt())
                .updateAt(projectEntity.getUpdateAt())
                .taskStates(projectEntity.getTaskStates().stream()
                        .map(taskStateEntity -> new TaskStateDTOFactory()
                                .toTaskStateDTO(taskStateEntity))
                        .collect(Collectors.toList()))
                .build();
    }
}
