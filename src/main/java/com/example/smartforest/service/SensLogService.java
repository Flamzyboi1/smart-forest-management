package com.example.smartforest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SensLogService {
    private final RestClient client;
    private final String baseUrl;
    public SensLogService(@Value("${senslog.base-url:http://localhost:8081}") String baseUrl) {
        this.baseUrl = baseUrl;
        this.client = RestClient.builder().baseUrl(baseUrl).build();
    }
    public String get(String path) {
        try { return client.get().uri(path).retrieve().body(String.class); }
        catch (RestClientException e) { throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "SensLog upstream unavailable at " + baseUrl + ". Check senslog.base-url and that SensLog is running.", e); }
    }
}
