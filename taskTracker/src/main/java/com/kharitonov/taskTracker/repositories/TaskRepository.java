package com.kharitonov.taskTracker.repositories;

import com.kharitonov.taskTracker.entites.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {


}
