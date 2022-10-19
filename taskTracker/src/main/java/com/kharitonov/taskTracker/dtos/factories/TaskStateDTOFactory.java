package com.kharitonov.taskTracker.dtos.factories;

import com.kharitonov.taskTracker.dtos.TaskStateDTO;
import com.kharitonov.taskTracker.entites.TaskStateEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TaskStateDTOFactory {

    public TaskStateDTO toTaskStateDTO(TaskStateEntity taskStateEntity) {
        return TaskStateDTO.builder()
                .id(taskStateEntity.getId())
                .name(taskStateEntity.getName())
                .createAt(taskStateEntity.getCreateAt())
                .updateAt(taskStateEntity.getUpdateAt())
                .position(taskStateEntity.getPosition())
                .tasks(taskStateEntity.getTasks().stream()
                        .map(taskEntity -> new TaskDTOFactory().toTaskDTO(taskEntity))
                        .collect(Collectors.toList()))
                .build();
    }
}
