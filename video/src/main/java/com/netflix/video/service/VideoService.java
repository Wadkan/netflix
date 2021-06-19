package com.netflix.video.service;

import com.netflix.video.entity.Video;
import com.netflix.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void saveVideo(Video updatedVideo) {
        videoRepository.save(updatedVideo);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public List<Video> getVideosWithRecommendation() {
        List<Video> videosWithRecommendation = videoRepository.findAll();

        videosWithRecommendation.stream().
                forEach(
                        video -> video.setRecommendation(recommendationCaller.getRecommendations(video.getId()))
                );
        return videosWithRecommendation;
    }
}
