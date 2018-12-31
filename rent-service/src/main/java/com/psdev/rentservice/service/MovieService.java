package com.psdev.rentservice.service;

import com.psdev.rentservice.model.Movie;

import java.util.List;

public interface MovieService {
    void saveMovie(Movie movie);

    Movie findByName(String movie);

    List<Movie> allMovies();
}
