package com.netflix.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecommendationList {
    private List<Recommendation> recommendations;

}
