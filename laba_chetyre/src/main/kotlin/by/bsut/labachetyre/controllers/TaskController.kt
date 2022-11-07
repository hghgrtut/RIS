package by.bsut.labachetyre.controllers

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import by.bsut.labachetyre.dto.TaskDTO
import by.bsut.labachetyre.dto.factories.TaskDTOFactory
import by.bsut.labachetyre.entites.TaskEntity
import by.bsut.labachetyre.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task")
class TaskController @Autowired constructor(

    private val taskService: TaskService,
    private val objectMapper: ObjectMapper
) {

    @get:Throws(JsonProcessingException::class)
    @get:GetMapping("/tasks")
    val all: String get() = objectMapper.writeValueAsString(
        taskService.findAll().stream().map { taskEntity -> TaskDTOFactory().toTaskDTO(taskEntity) }.toList()
    )

    @PostMapping("/{id}")
    @Throws(JsonProcessingException::class)
    fun createTask(@RequestBody bodyParams: Map<String?, String?>): String {
        val taskEntity: TaskEntity = getTaskEntity()
        taskService.save(taskEntity)
        return objectMapper.writeValueAsString(TaskDTOFactory().toTaskDTO(taskEntity))
    }

    @PatchMapping("/{id}")
    @Throws(JsonProcessingException::class)
    fun updateTask(@PathVariable("id") id: Int, @RequestBody bodyParams: Map<String?, String?>): String {
        val entity: TaskEntity = taskService.copyProperties(taskService.findById(id), getTaskEntity())
        taskService.save(entity)
        return objectMapper.writeValueAsString(TaskDTOFactory().toTaskDTO(entity))
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable("id") id: Int) = taskService.deleteById(id)

    private fun getTaskEntity() = Builder().name(bodyParams["name"]).description(bodyParams["description"]).build()
}