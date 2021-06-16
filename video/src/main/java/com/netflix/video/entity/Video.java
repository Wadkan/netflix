package com.netflix.video.entity;

import com.netflix.video.model.Recommendation;
import com.netflix.video.model.Recommendations;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Video {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String url;

    @Transient
    private List<Object> recommendation;

}
