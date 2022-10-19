package com.example.someMangaLib.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TitleStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
