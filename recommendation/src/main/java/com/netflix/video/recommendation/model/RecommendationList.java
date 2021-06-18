package com.netflix.video.recommendation.model;

import com.netflix.video.recommendation.entity.Recommendation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationList {
    private String port;
    private List<Recommendation> recommendations;

}
