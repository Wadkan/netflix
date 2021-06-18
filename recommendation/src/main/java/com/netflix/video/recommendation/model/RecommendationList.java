package com.netflix.video.recommendation.model;

import com.netflix.video.recommendation.entity.Recommendation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecommendationList {
    private List<Recommendation> recommendations;

}
