package com.kharitonov.taskTracker.services;

import com.kharitonov.taskTracker.dtos.TaskDTO;
import com.kharitonov.taskTracker.dtos.factories.TaskDTOFactory;
import com.kharitonov.taskTracker.entites.TaskEntity;
import com.kharitonov.taskTracker.exceptions.BadRequestException;
import com.kharitonov.taskTracker.exceptions.NotFoundException;
import com.kharitonov.taskTracker.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskEntity -> new TaskDTOFactory().toTaskDTO(taskEntity))
                .toList();
    }

    public TaskDTO save(Optional<TaskEntity> optionalTaskEntity) {
        TaskEntity taskEntity = optionalTaskEntity.orElseThrow(BadRequestException::new);

        return new TaskDTOFactory().toTaskDTO(taskRepository.save(taskEntity));
    }

    public TaskDTO update(Optional<TaskEntity> optionalTaskEntityFromDB, Optional <TaskEntity> optionalTaskEntity) {
        if(optionalTaskEntityFromDB.isEmpty() || optionalTaskEntity.isEmpty()) {
            throw new BadRequestException("Object was not found.");
        }
        BeanUtils.copyProperties(optionalTaskEntity.get(), optionalTaskEntityFromDB.get(), "id");
        return save(optionalTaskEntityFromDB);
    }

    public TaskDTO findById(Optional<Long> optionalId) {
        Long id = optionalId.orElseThrow(BadRequestException::new);
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(NotFoundException::new);
        return new TaskDTOFactory().toTaskDTO(taskEntity);
    }

    public void deleteById(Optional<Long> optionalId) {
        Long id = optionalId.orElseThrow(BadRequestException::new);
        taskRepository.deleteById(id);
    }

}
