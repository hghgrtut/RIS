package by.bsut.labachetyre.repositories

import by.bsut.labachetyre.entites.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TaskJpaRepository : JpaRepository<TaskEntity, Long>