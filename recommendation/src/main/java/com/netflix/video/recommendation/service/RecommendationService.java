package com.netflix.video.recommendation.service;

import com.netflix.video.recommendation.entity.Recommendation;
import com.netflix.video.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    RecommendationRepository recommendationRepository;


    public List<Recommendation> getAllRecommendation(Long id) {
        return recommendationRepository.findRecommendationsByVideoId(id);
    }

    public void saveAllRecommendation(List<Recommendation> recommendations) {
        recommendationRepository.saveAll(recommendations);
    }
}
