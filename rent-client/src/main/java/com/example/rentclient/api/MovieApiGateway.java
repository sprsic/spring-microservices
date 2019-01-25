package com.example.rentclient.api;

import com.example.rentclient.model.LeaseModel;
import com.example.rentclient.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieApiGateway {

    private static String URL = "http://rent-service/movie";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MovieModel>> allMovies() {
        URI url = URI.create(URL + "/all");
        UriComponents uri = UriComponentsBuilder.fromUri(url).build();
        ParameterizedTypeReference<List<MovieModel>> ptr =
                new ParameterizedTypeReference<List<MovieModel>>() {
                };
        return restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, null, ptr);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveMovie(@RequestBody MovieModel movieModel) {
        URI url = URI.create(URL);
        UriComponents uri = UriComponentsBuilder.fromUri(url).build();
        HttpEntity<MovieModel> httpEntity = new HttpEntity<>(movieModel);
        return restTemplate.postForEntity(uri.toUri(), httpEntity, Void.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByMovieName")
    public ResponseEntity<MovieModel> leasesOfUser(@RequestParam("movieName") String movieName) {

        URI url = URI.create(URL + "/findByMovieName");
        UriComponents uri = UriComponentsBuilder.fromUri(url)
                .queryParam("movieName", movieName).build();
        return restTemplate.getForEntity(uri.toUri(), MovieModel.class);
    }
}
