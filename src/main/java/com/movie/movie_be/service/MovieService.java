package com.movie.movie_be.service;

import com.movie.movie_be.dto.MovieDTO;
import com.movie.movie_be.entity.Information;
import com.movie.movie_be.entity.Movie;
import com.movie.movie_be.repository.ActorRepository;
import com.movie.movie_be.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ActorRepository actorRepository;

    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    public Movie postMovie(Movie movie) {
        Movie newMovie = movieRepository.save(movie);
        return newMovie;
    }

    public Movie getMovieDetailById(long movieId) {
        Movie newMovie = movieRepository.findMovieById(movieId);
        return newMovie;
    }

    public List<Movie> getMovieDetailByName(String movieName) {
        List<Movie> movies = movieRepository.find(movieName);
        return movies;
    }

    public void addData(){
        Movie movie = movieRepository.findMovieById(1);
        List<Information> actors = actorRepository.findAll();
        movie.setActors(actors);
        movieRepository.save(movie);
    }

}
