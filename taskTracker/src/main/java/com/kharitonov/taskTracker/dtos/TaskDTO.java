package com.kharitonov.taskTracker.dtos;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Instant createAt;
    @NonNull
    private Instant updateAt;
    @NonNull
    private String description;
}
