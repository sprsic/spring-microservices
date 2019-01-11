package com.psdev.rentservice.service;

import com.psdev.rentservice.entity.Movie;
import com.psdev.rentservice.entity.model.MovieModel;

import java.util.List;

public interface MovieService {

    void saveMovie(MovieModel movie);

    /**
     * Returns a movie details for a given movie name
     *
     *
     */

    Movie findByName(String movie);

    /**
     * Returns a list of all movies
     *
     * @return
     */

    List<Movie> allMovies();
}
