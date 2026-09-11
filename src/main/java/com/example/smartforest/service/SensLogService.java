package com.example.smartforest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SensLogService {
    private final RestClient client;
    public SensLogService(@Value("${senslog.base-url:http://localhost:8081}") String baseUrl) {
        this.client = RestClient.builder().baseUrl(baseUrl).build();
    }
    public String get(String path) { return client.get().uri(path).retrieve().body(String.class); }
}
