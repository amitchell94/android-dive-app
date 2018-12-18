package com.codingnomads.andy.mydivingapplication.data;

import com.codingnomads.andy.mydivingapplication.logic.Dive;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class DiveRepository {

    private RestTemplate restTemplate;

    private String token = "token";

    public DiveRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Dive> getAllDives() {
        Dive[] diveList = restTemplate.getForObject(getUri("api/logbook/dives/?token=" + token), Dive[].class);
        return Arrays.asList(diveList);
    }

    private URI getUri(String path) {
        return UriComponentsBuilder.fromUriString("http://192.168.0.110")
                .port("8080")
                .path(path)
                .build()
                .encode()
                .toUri();
    }

    public Dive saveDive(Dive dive) {
        return restTemplate.postForObject(getUri("api/logbook/dives/"),dive,Dive.class);
    }
}
