package com.movie.movie_be.controller;

import com.movie.movie_be.dto.MovieDTO;
import com.movie.movie_be.entity.Movie;
import com.movie.movie_be.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/", "http://localhost:5174/" , "https://xxx.com"})
public class MovieController {
    // METHOD
    // GET
    // POST
    //CRUD
    @Autowired
    MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity getMovies(){
        List<Movie> movies =  movieService.getMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping("movie")
    public ResponseEntity postMovie(@RequestBody Movie movie){
        // Expected 1 arguments but found 0
        Movie movies =  movieService.postMovie(movie);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("movies")
    public ResponseEntity postMovies(@RequestBody List<Movie> movies){
        // Expected 1 arguments but found 0
        List<Movie> newMovies =  movieService.postMovies(movies);
        return ResponseEntity.ok(newMovies);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity getMovieDetail(@PathVariable long movieId){
        // Expected 1 arguments but found 0
        Movie movies =  movieService.getMovieDetailById(movieId);
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/movie-by-name")
    public ResponseEntity getMovieDetailByName(@RequestParam String movieName){
        // Expected 1 arguments but found 0
        List<Movie> movies =  movieService.getMovieDetailByName(movieName);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/add-data")
    public void addData(){
        movieService.addData();
    }

}
