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
@Table(name = "task_states")
public class TaskStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(updatable = false)
    private Instant createAt = Instant.now();
    private Instant updateAt = Instant.now();
    private int position;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_state_id")
    private List<TaskEntity> tasks = new ArrayList<>();
}
