package com.psdev.rentservice.service;

import com.psdev.rentservice.entity.model.MovieModel;
import com.psdev.rentservice.repository.MovieRepository;
import com.psdev.rentservice.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveMovie(MovieModel movie) {
        Movie m = new Movie();
        m.setName(movie.getName());
        m.setRank(movie.getRank());
        movieRepository.save(m);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Movie> allMovies() {
        //TODO needs pagination
        return movieRepository.findAll();
    }
}
