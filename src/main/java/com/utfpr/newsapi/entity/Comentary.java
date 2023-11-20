package com.utfpr.newsapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Comentary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String info;

    // Relacionamento muitos-para-um com a entidade User
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Relacionamento muitos-para-um com a entidade Report
    @ManyToOne
    @JoinColumn(name = "reportId", nullable = false)
    private Report report;

    private Date publicationDate;

}
