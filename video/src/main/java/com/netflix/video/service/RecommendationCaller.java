package com.netflix.video.service;

import com.netflix.video.model.Recommendation;
import com.netflix.video.model.Recommendations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecommendationCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("http://localhost:8086/recommendtation/recommendation/")
    private String baseUrl;

    public List<Object> getRecommendations(Long id) {   // List<Recommendation>
        Recommendations recommendations = restTemplate.getForEntity(baseUrl + id, Recommendations.class).getBody();
        List<Object> recommendationsList = recommendations.getRecommendations();
        return recommendationsList;

    }
}
