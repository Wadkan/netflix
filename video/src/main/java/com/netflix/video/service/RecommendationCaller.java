package com.netflix.video.service;

import com.netflix.video.model.Recommendation;
import com.netflix.video.model.Recommendations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RecommendationCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation-url}")
    private String baseUrl;

    public List<Object> getRecommendations(Long id) {   // List<Recommendation>
        Recommendations recommendations = restTemplate.getForEntity(baseUrl + id, Recommendations.class).getBody();
        List<Object> recommendationsList = recommendations.getRecommendations();
        return recommendationsList;
    }
}
