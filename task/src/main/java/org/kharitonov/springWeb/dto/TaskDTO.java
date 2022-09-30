package org.kharitonov.springWeb.dto;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Component
public class TaskDTO {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private LocalDateTime createAt;
    @NonNull
    private String description;

    public TaskDTO() {
    }

    public int getId() {
        return id;
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

    public static class Builder {
        private TaskDTO taskDTO;

        public Builder() {
            taskDTO = new TaskDTO();
        }

        public Builder id(int id) {
            taskDTO.id = id;
            return this;
        }

        public Builder name(String name) {
            taskDTO.name = name;
            return this;
        }

        public Builder createAt(LocalDateTime createAt) {
            taskDTO.createAt = createAt;
            return this;
        }

        public Builder description(String description) {
            taskDTO.description = description;
            return this;
        }

        public TaskDTO build() {
            return this.taskDTO;
        }
    }
}
