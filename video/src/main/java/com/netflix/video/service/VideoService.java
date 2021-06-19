package com.netflix.video.service;

import com.netflix.video.entity.Video;
import com.netflix.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    RecommendationCaller recommendationCaller;

    public Optional<Video> getVideoWithRecommendation(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        video.get().setRecommendation(recommendationCaller.getRecommendations(video.get().getId()));
        return video;
    }
}
