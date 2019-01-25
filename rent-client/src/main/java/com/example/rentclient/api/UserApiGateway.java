package com.example.rentclient.api;

import com.example.rentclient.model.MovieModel;
import com.example.rentclient.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping("/user")
public class UserApiGateway {
    private static String URL = "http://rent-service/user";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody UserModel userModel) {
        URI url = URI.create(URL);
        UriComponents uri = UriComponentsBuilder.fromUri(url).build();
        HttpEntity<UserModel> httpEntity = new HttpEntity<>(userModel);
        ResponseEntity<Void> rsp = restTemplate.postForEntity(uri.toUri(), httpEntity, Void.class);
        if (rsp.getStatusCode() != HttpStatus.NO_CONTENT) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("oops, something went wrong");
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserModel> findByUsername(@RequestParam("username") String username) {
        URI url = URI.create(URL);
        UriComponentsBuilder uri = UriComponentsBuilder.fromUri(url)
                .queryParam("username", username);
        return restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, null, UserModel.class);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> listAllUsers() {

        URI url = URI.create(URL + "/all");
        UriComponents uri = UriComponentsBuilder.fromUri(url).build();

        ParameterizedTypeReference<List<UserModel>> ptr =
                new ParameterizedTypeReference<List<UserModel>>() {
                };
        return restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, null, ptr);
    }

}
