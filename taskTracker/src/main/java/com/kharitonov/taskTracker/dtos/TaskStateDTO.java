package com.kharitonov.taskTracker.dtos;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskStateDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Instant createAt;
    @NonNull
    private Instant updateAt;
    @NonNull
    private int position;
    @NonNull
    private List<TaskDTO> tasks;
}
