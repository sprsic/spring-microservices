package com.psdev.rentservice.service;

import com.psdev.rentservice.model.Movie;

import java.util.List;

public interface MovieService {

    void saveMovie(Movie movie);

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
