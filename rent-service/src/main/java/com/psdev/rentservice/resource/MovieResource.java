package com.psdev.rentservice.resource;

import com.psdev.rentservice.model.Movie;
import com.psdev.rentservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RefreshScope
public class MovieResource {
    @Autowired
    private MovieService movieService;

    @RequestMapping("/findByMovieName")
    public Movie findByUser(@Param("movieName") String movieName) {
        System.out.println(movieName);
        return movieService.findByName(movieName);
    }

    //todo needs paging
    @RequestMapping("/allMovies")
    public List<String> allMovies() {
        return movieService.allMovies().stream().map(Movie::getName).collect(Collectors.toList());
    }
}
