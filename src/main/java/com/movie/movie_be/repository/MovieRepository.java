package com.movie.movie_be.repository;

import com.movie.movie_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findMovieById(long id);

    @Query("SELECT mv FROM Movie mv WHERE mv.name LIKE %?1%")
    List<Movie> find(String keyword); //Conan

//    List<Movie> findMovieByNameContaining(String keyword);
}
