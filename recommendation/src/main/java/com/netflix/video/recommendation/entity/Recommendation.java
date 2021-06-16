package com.netflix.video.recommendation.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recommendation {

    @Id
    @GeneratedValue
    private long id;

    private Integer rating;

    private String comment;

    private Long videoId;
}
