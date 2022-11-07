package by.bsut.labachetyre.dto.factories

import by.bsut.labachetyre.dto.TaskDTO
import by.bsut.labachetyre.entites.TaskEntity
import org.springframework.stereotype.Component

@java.awt.Component
class TaskDTOFactory {

    fun toTaskDTO(taskEntity: TaskEntity): TaskDTO = Builder().id(taskEntity.getId())
        .name(taskEntity.getName())
        .createAt(taskEntity.getCreateAt())
        .description(taskEntity.getDescription())
        .build()
}