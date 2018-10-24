package com.codingnomads.andy.mydivingapplication;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

public class DiveRepository {

    RestTemplate restTemplate;

    public DiveRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Dive> getAllDives() {
        URI uri = getUri();
        Dive[] diveList = restTemplate.getForObject(uri, Dive[].class);
        return Arrays.asList(diveList);
    }

    private URI getUri() {
        return UriComponentsBuilder.fromUriString("http://192.168.0.110")
                .port("8080")
                .path("/logbook/dives/")
                .build()
                .encode()
                .toUri();
    }
}
