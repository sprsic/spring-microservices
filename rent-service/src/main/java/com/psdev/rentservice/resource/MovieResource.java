package com.psdev.rentservice.resource;

import com.psdev.rentservice.entity.Movie;
import com.psdev.rentservice.entity.model.MovieModel;
import com.psdev.rentservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController@RequestMapping("/movie")
public class MovieResource {
    @Autowired
    private MovieService movieService;

    @RequestMapping(path = "/findByMovieName", method = RequestMethod.GET)
    public ResponseEntity<Movie> findByUser(@Param("movieName") String movieName) {
        Movie movie = movieService.findByName(movieName);
        return ResponseEntity.ok(movie);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveMovie(@RequestBody MovieModel movie) {
        movieService.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> allMovies() {
        List<Movie> allMovies = movieService.allMovies();
        return ResponseEntity.ok(allMovies);
    }
}
