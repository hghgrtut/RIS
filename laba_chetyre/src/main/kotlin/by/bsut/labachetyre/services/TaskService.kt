package by.bsut.labachetyre.services

import by.bsut.labachetyre.dto.TaskDTO
import by.bsut.labachetyre.dto.factories.TaskDTOFactory
import by.bsut.labachetyre.entites.TaskEntity
import by.bsut.labachetyre.repositories.TaskRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService @Autowired constructor(private val taskRepository: TaskRepository) {

    fun findAll(): List<TaskEntity> = taskRepository.findAll()

    fun save(taskEntity: TaskEntity): TaskEntity {
        taskRepository.save(taskEntity)
        return taskEntity
    }

    fun findById(id: Int): TaskEntity = taskRepository.findById(id)

    fun deleteById(id: Int) = taskRepository.deleteById(id)

    fun copyProperties(taskEntityFormDB: TaskEntity, taskEntity: TaskEntity): TaskEntity = taskEntityFormDB.apply {
        name(taskEntity.name())
        createAt(taskEntity.createAt())
        description(taskEntityFormDB.description())
    }
}