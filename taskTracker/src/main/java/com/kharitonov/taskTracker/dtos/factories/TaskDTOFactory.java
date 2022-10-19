package com.kharitonov.taskTracker.dtos.factories;

import com.kharitonov.taskTracker.dtos.TaskDTO;
import com.kharitonov.taskTracker.entites.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOFactory {

    public TaskDTO toTaskDTO(TaskEntity taskEntity) {
        return TaskDTO.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .createAt(taskEntity.getCreateAt())
                .updateAt(taskEntity.getUpdateAt())
                .description(taskEntity.getDescription())
                .build();
    }
}
