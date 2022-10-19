package com.kharitonov.taskTracker.repositories;

import com.kharitonov.taskTracker.entites.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<ProjectEntity> findByNameIgnoreCase(String name);
    
}
