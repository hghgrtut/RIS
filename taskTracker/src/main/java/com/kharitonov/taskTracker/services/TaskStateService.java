package com.kharitonov.taskTracker.services;

import com.kharitonov.taskTracker.dtos.TaskStateDTO;
import com.kharitonov.taskTracker.dtos.factories.TaskStateDTOFactory;
import com.kharitonov.taskTracker.entites.TaskEntity;
import com.kharitonov.taskTracker.entites.TaskStateEntity;
import com.kharitonov.taskTracker.exceptions.BadRequestException;
import com.kharitonov.taskTracker.exceptions.NotFoundException;
import com.kharitonov.taskTracker.repositories.TaskStateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class TaskStateService {
    private final TaskStateRepository taskStateRepository;

    @Autowired
    public TaskStateService(TaskStateRepository taskStateRepository) {
        this.taskStateRepository = taskStateRepository;
    }

    public List<TaskStateDTO> findAll() {
        return taskStateRepository.findAll()
                .stream()
                .map(taskStateEntity -> new TaskStateDTOFactory().toTaskStateDTO(taskStateEntity))
                .toList();
    }

    public TaskStateDTO findById(Optional<Long> optionalId) {
        Long id  = optionalId.orElseThrow(NotFoundException::new);
        TaskStateEntity taskState = taskStateRepository.findById(id).orElseThrow(NotFoundException::new);

        return new TaskStateDTOFactory().toTaskStateDTO(taskState);
    }

    public TaskStateDTO save(Optional<TaskStateEntity> taskStateEntity) {
        TaskStateEntity taskState = taskStateEntity.get();
        if(taskState.getName().trim().isEmpty()) {
            throw new BadRequestException("Task state name can't be empty.");
        }

        return new TaskStateDTOFactory().toTaskStateDTO(taskStateRepository.save(taskState));
    }

    public TaskStateDTO update(Optional<TaskStateEntity> optionalTaskStateEntityFromDB,
                               Optional<TaskStateEntity> optionalTaskStateEntity) {
        if(optionalTaskStateEntityFromDB.isEmpty() || optionalTaskStateEntity.isEmpty()) {
            throw new BadRequestException("Object is not found.");
        }
        BeanUtils.copyProperties(optionalTaskStateEntity.get(), optionalTaskStateEntityFromDB.get(), "id");
        return save(optionalTaskStateEntityFromDB);
    }

    public TaskStateDTO addTask(Optional<TaskStateEntity> taskStateEntity, Optional<TaskEntity> taskEntity) {
        if(taskStateEntity.isEmpty() | taskEntity.isEmpty()) {
            throw new NotFoundException("Object was not found.");
        }

        TaskStateEntity taskState = taskStateEntity.get();
        taskState.getTasks().add(taskEntity.get());

        return new TaskStateDTOFactory().toTaskStateDTO(taskStateRepository.save(taskState));
    }


    public void deleteById(Optional<Long> optionalId) {
        Long id = optionalId.orElseThrow(BadRequestException::new);
        taskStateRepository.deleteById(id);
    }

}
