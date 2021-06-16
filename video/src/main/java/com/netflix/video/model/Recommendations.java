package com.netflix.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Recommendations {
    private String port;

    private List<Object> recommendations;

}
