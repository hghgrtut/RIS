package by.bsut.labachetyre.repositories

import by.bsut.labachetyre.annotations.IdAnnotation
import by.bsut.labachetyre.entites.TaskEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TaskRepository @Autowired constructor(private val idAnnotation: IdAnnotation) {

    private val tasks: MutableList<TaskEntity> = ArrayList<TaskEntity>()

    fun findAll(): List<TaskEntity> = tasks

    fun findById(id: Int): TaskEntity = tasks.stream()
            .filter(function.Predicate<TaskEntity> { task: TaskEntity -> task.getId() === id })
            .findAny()
            .orElseThrow<NullPointerException>(Supplier<NullPointerException> { NullPointerException() })

    fun save(task: TaskEntity) {
        idAnnotation.setFieldId(task)
        tasks.add(task)
    }

    fun deleteById(id: Int) = tasks.remove(findById(id))
}