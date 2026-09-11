package com.example.smartforest.service;

import java.time.Duration;
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
    public SensLogService(
            @Value("${senslog.base-url:http://localhost:8081}") String baseUrl,
            @Value("${senslog.connect-timeout-ms:5000}") long connectTimeoutMs,
            @Value("${senslog.read-timeout-ms:15000}") long readTimeoutMs) {
        this.baseUrl = baseUrl;
        this.client = RestClient.builder().baseUrl(baseUrl).build();
    }
    public String get(String path) {
        try {
            return client.get().uri(path).retrieve().body(String.class);
        } catch (RestClientException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY,
                    "Cannot reach SensLog at " + baseUrl + ". Set SENSLOG_BASE_URL to the same URL used by the working irrigation application and restart Smart Forest.",
                    e);
        }
    }
}
