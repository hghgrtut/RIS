package org.kharitonov.springWeb.dto.factories;

import org.kharitonov.springWeb.dto.TaskDTO;
import org.kharitonov.springWeb.entites.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOFactory {

    public TaskDTO toTaskDTO(TaskEntity taskEntity) {
        return new TaskDTO.Builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .createAt(taskEntity.getCreateAt())
                .description(taskEntity.getDescription())
                .build();
    }
}
