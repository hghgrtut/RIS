package com.kharitonov.taskTracker.repositories;

import com.kharitonov.taskTracker.entites.TaskStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {

}
