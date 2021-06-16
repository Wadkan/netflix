package com.netflix.video;

import com.netflix.video.entity.Video;
import com.netflix.video.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
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
                    .url("https://www.youtube.com/watch?v=gMdMkuFYW7E")
                    .build();
            videoRepository.save(video1);

            Video video2 = Video.builder()
                    .name("JWT")
                    .url("https://www.youtube.com/watch?v=7Q17ubqLfaM&ab_channel=WebDevSimplifiedWebDevSimplified")
                    .build();
            videoRepository.save(video2);

            Video video3 = Video.builder()
                    .name("Java vs Python")
                    .url("https://www.youtube.com/watch?v=yrw16gSTgpc&ab_channel=IntellipaatIntellipaat")
                    .build();
            videoRepository.save(video3);

            log.info("==================");
            log.info("IN MEMORY DATA: " + videoRepository.findAll());
        };
    }

}
