package com.netflix.video.recommendation.controller;

import com.netflix.video.recommendation.entity.Recommendation;
import com.netflix.video.recommendation.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/recommendtation")
public class RecomendationController {

    @Autowired
    private Environment environment;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping("/recommendation/{id}")
    public Recommendations getRecomendations(@PathVariable("id") Long id){
        return new Recommendations(
                environment.getProperty("server.port"),
                recommendationRepository.findRecommendationsByVideoId(id)
        );
    }

    @Data
    @AllArgsConstructor
    private class Recommendations {
        private String port;
        private List<Recommendation> recommendations;
    }
}
