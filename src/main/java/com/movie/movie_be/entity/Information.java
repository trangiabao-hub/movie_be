package com.movie.movie_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor // CẤP CHO TAO 1 CONSTRUCTOR FULL THAM SỐ
@NoArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String avatarURL;
    private String name;

    @OneToMany(mappedBy = "director")
    @JsonIgnore
    List<Movie> directorOfMovie;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    List<Movie> actorOfMovie;
}
