package com.kharitonov.taskTracker.dtos;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Instant createAt;
    @NonNull
    private Instant updateAt;
    @NonNull
    private List<TaskStateDTO> taskStates;
}
