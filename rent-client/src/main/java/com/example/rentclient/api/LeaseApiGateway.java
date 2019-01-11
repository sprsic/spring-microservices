package com.example.rentclient.api;

import com.example.rentclient.model.LeaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lease")
class LeaseApiGateway {
    private static String URL = "http://rent-service/lease";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/findByUsername")
    public ResponseEntity leasesOfUser(@RequestParam("username") String username) {
        ParameterizedTypeReference<List<LeaseModel>> ptr =
                new ParameterizedTypeReference<List<LeaseModel>>() {
                };

        URI url = URI.create(URL + "/byUserName");
        UriComponentsBuilder uri = UriComponentsBuilder.fromUri(url)
                .queryParam("userName", username);
        //rent-service is the name of the registered service
        return restTemplate.exchange(uri.toUriString(),
                HttpMethod.GET, null, ptr);
    }
}
