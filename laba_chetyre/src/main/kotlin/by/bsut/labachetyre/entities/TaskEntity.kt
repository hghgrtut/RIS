package by.bsut.labachetyre.entites

import by.bsut.labachetyre.annotations.Id

data class TaskEntity() {

    @Id
    var id = 0
    var name: String? = null
    var createAt: LocalDateTime = LocalDateTime.now()
    var description: String? = null

    constructor(name: String?, description: String?) {
        this.name = name
        this.description = description
    }

    class Builder {

        private val taskEntity: TaskEntity = TaskEntity()

        fun name(name: String?): Builder {
            taskEntity.name = name
            return this
        }

        fun description(description: String?): Builder {
            taskEntity.description = description
            return this
        }

        fun build(): TaskEntity = taskEntity
    }
}