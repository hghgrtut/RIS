package org.kharitonov.springWeb.entites;

import org.kharitonov.springWeb.annotations.Id;

import java.time.LocalDateTime;

public class TaskEntity {
    @Id
    private int id;
    private String name;
    private LocalDateTime createAt = LocalDateTime.now();
    private String description;

    public TaskEntity() {
    }

    public TaskEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private TaskEntity taskEntity;

        public Builder() {
            taskEntity = new TaskEntity();
        }


        public Builder name(String name) {
            taskEntity.name = name;
            return this;
        }

        public Builder description(String description) {
            taskEntity.description = description;
            return this;
        }

        public TaskEntity build() {
            return this.taskEntity;
        }



    }
}
