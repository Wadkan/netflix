package com.netflix.video;

import com.netflix.video.entity.Video;
import com.netflix.video.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class VideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }

    @Autowired
    private VideoRepository videoRepository;

    @Bean
//    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Video video1 = Video.builder()
                    .name("Lucifer")
                    .url("gMdMkuFYW7E")
                    .build();
            videoRepository.save(video1);

            Video video2 = Video.builder()
                    .name("JWT")
                    .url("7Q17ubqLfaM")
                    .build();
            videoRepository.save(video2);

            Video video3 = Video.builder()
                    .name("Java vs Python")
                    .url("yrw16gSTgpc")
                    .build();
            videoRepository.save(video3);

            log.info("==================");
            log.info("IN MEMORY DATA: " + videoRepository.findAll());
        };
    }

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
