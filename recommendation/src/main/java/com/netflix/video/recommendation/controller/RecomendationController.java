package com.netflix.video.recommendation.controller;

import com.netflix.video.recommendation.entity.Recommendation;
import com.netflix.video.recommendation.model.RecommendationList;
import com.netflix.video.recommendation.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/recommendation")
public class RecomendationController {

    @Autowired
    private Environment environment;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping("/{id}")
    public Recommendations getRecommendations(@PathVariable("id") Long id){
        return new Recommendations(
                environment.getProperty("server.port"),
                recommendationRepository.findRecommendationsByVideoId(id)
        );
    }

    @PutMapping("/update")
    public void updateRecommendations(@RequestBody RecommendationList recommendationList){
        recommendationRepository.saveAll(recommendationList.getRecommendations());
    }

    @Data
    @AllArgsConstructor
    private class Recommendations {
        private String port;
        private List<Recommendation> recommendations;
    }

}
