package com.psdev.rentservice.service;

import com.psdev.rentservice.repository.MovieRepository;
import com.psdev.rentservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    public List<Movie> allMovies() {
        //TODO needs pagination
        return movieRepository.findAll();
    }
}
