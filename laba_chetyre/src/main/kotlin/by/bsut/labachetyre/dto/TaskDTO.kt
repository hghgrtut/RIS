package by.bsut.labachetyre.dto

import org.springframework.lang.NonNull
import org.springframework.stereotype.Component

@java.awt.Component
class TaskDTO {

    var id = 0
    var name: String = ""
    var createAt: LocalDateTime = ""
    var description: String = ""

    class Builder {

        private val taskDTO: TaskDTO = TaskDTO()

        fun id(id: Int): Builder {
            taskDTO.id = id
            return this
        }

        fun name(name: String?): Builder {
            taskDTO.name = name
            return this
        }

        fun createAt(createAt: LocalDateTime?): Builder {
            taskDTO.createAt = createAt
            return this
        }

        fun description(description: String?): Builder {
            taskDTO.description = description
            return this
        }

        fun build(): TaskDTO {
            return taskDTO
        }
    }
}