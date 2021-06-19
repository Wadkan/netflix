package com.netflix.video.controller;

import com.netflix.video.entity.Video;
import com.netflix.video.repository.VideoRepository;
import com.netflix.video.service.RecommendationCaller;
import com.netflix.video.service.VideoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private Environment environment;

    @Autowired
    VideoService videoService;


    @GetMapping("/{id}")
    public OneVideo getVideoById(@PathVariable("id") Long id) {

        return new OneVideo(
                environment.getProperty("server.port"),
                videoService.getVideoWithRecommendation(id)
        );
    }

//    @PutMapping("/{id}")
//    public OneVideo updateVideoById(@RequestBody Video updatedVideo) {
//        videoRepository.save(updatedVideo);
//
//        return new OneVideo(
//                environment.getProperty("server.port"),
//                Optional.of(updatedVideo)
//        );
//    }
//
//    @GetMapping("/all")
//    public Videos getAllVideos() {
//        return new Videos(
//                environment.getProperty("server.port"),
//                videoRepository.findAll()
//        );
//    }
//
//    @GetMapping("/all-with-recommend")
//    private Videos getAllVideosWithRecommendtations() {
//
//        List<Video> videosWithRecommendation = videoRepository.findAll();
//
//        videosWithRecommendation.stream().
//                forEach(
//                        video -> video.setRecommendation(recommendationCaller.getRecommendations(video.getId()))
//                );
//
//
//        Videos videos = new Videos(
//                environment.getProperty("server.port"),
//                videosWithRecommendation
//        );
//
//        return videos;
//    }


    @Data
    @AllArgsConstructor
    public class Videos {
        private String port;
        private List<Video> videos;
    }

    @Data
    @AllArgsConstructor
    public class OneVideo {
        private String port;
        private Optional<Video> video;
    }

}
