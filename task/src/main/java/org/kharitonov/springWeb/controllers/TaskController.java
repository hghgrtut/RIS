package org.kharitonov.springWeb.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kharitonov.springWeb.dto.TaskDTO;
import org.kharitonov.springWeb.dto.factories.TaskDTOFactory;
import org.kharitonov.springWeb.entites.TaskEntity;
import org.kharitonov.springWeb.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final ObjectMapper objectMapper;

    @Autowired
    public TaskController(TaskService taskService, ObjectMapper objectMapper) {
        this.taskService = taskService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/tasks")
    public String getAll() throws JsonProcessingException {
        List<TaskDTO> taskDTOS = taskService.findAll()
                .stream()
                .map(taskEntity -> new TaskDTOFactory().toTaskDTO(taskEntity))
                .toList();
        return objectMapper.writeValueAsString(taskDTOS);
    }

    @PostMapping
    public String createTask(@RequestBody Map<String,String> bodyParams) throws JsonProcessingException {
        TaskEntity taskEntity = new TaskEntity.Builder()
                .name(bodyParams.get("name"))
                .description(bodyParams.get("description"))
                .build();
        taskService.save(taskEntity);
        return objectMapper.writeValueAsString(new TaskDTOFactory().toTaskDTO(taskEntity));
    }

    @PatchMapping("/{id}")
    public String updateTask(@PathVariable("id") int id, @RequestBody Map<String, String> bodyParams) throws JsonProcessingException {
        TaskEntity taskEntityFromDB = taskService.findById(id);
        TaskEntity taskEntity = new TaskEntity.Builder()
                .name(bodyParams.get("name"))
                .description(bodyParams.get("description"))
                .build();
        TaskEntity entity = taskService.copyProperties(taskEntityFromDB, taskEntity);
        taskService.save(entity);
        TaskDTO taskDTO = new TaskDTOFactory().toTaskDTO(entity);
        return objectMapper.writeValueAsString(taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.deleteById(id);
    }
}
