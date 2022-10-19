package com.kharitonov.taskTracker.entites;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(updatable = false)
    private Instant createAt = Instant.now();
    private Instant updateAt = Instant.now();
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    @OrderBy(value = "position ASC")
    private List<TaskStateEntity> taskStates = new ArrayList<>();
}
