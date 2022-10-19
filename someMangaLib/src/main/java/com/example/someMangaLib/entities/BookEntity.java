package com.example.someMangaLib.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String name;
    private String author;
    private Integer countPages;
    @OneToOne
    private TitleStatusEntity titleStatusEntity;
    @OneToOne
    private TranslateStatusEntity translateStatusEntity;
}
