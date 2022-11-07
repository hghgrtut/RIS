package by.bsut.labachetyre.services

import by.bsut.labachetyre.dto.TaskDTO
import by.bsut.labachetyre.dto.factories.TaskDTOFactory
import by.bsut.labachetyre.entites.TaskEntity
import by.bsut.labachetyre.repositories.TaskJpaRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService @Autowired constructor(private val taskRepository: TaskJpaRepository) {

    fun findAll(): List<TaskEntity> = taskRepository.findAll()

    fun save(taskEntity: TaskEntity): TaskEntity {
        taskRepository.save(taskEntity)
        return taskEntity
    }

    fun findById(id: Long): TaskEntity = taskRepository.getOne(id)

    fun deleteById(id: Long) = taskRepository.deleteById(id)
}