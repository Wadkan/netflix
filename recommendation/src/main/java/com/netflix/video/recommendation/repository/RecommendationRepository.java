package com.netflix.video.recommendation.repository;

import com.netflix.video.recommendation.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findRecommendationsByVideoId(Long videoId);
}
