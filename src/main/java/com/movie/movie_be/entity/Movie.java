package com.movie.movie_be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    Information director;

    @ManyToMany()
    Set<Information> actors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) && Objects.equals(image, movie.image) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(director, movie.director) && Objects.equals(actors, movie.actors) && Objects.equals(categories, movie.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, releaseDate, director, actors, categories);
    }

    @ManyToMany()
    Set<Category> categories;
}
