package com.movie.movie_be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor // CẤP CHO TAO 1 CONSTRUCTOR FULL THAM SỐ
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String image;
    private int year;

    @ManyToOne
    @JoinColumn(name = "director_id")
    Information director;

    @ManyToMany()
    List<Information> actors;
}
