package com.kharitonov.myTestApi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String body;
}
