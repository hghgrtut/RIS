package by.bsut.labachetyre.entites

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Data
@Entity
@Table(name = "people")
data class TaskEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
    @Column(name = "name")
    var name: String? = null
    @Column(name = "createAt")
    var createAt: LocalDateTime = LocalDateTime.now()
    @Column(name = "description")
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