package com.netflix.video.recommendation;

import com.netflix.video.recommendation.entity.Recommendation;
import com.netflix.video.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RecommendationApplication {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecommendationApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Recommendation recommendation1 = Recommendation.builder()
                    .comment("Very good!")
                    .rating(4)
                    .videoId((long) 1)
                    .build();
            recommendationRepository.save(recommendation1);


            Recommendation recommendation2 = Recommendation.builder()
                    .comment("I love it!!")
                    .rating(5)
                    .videoId((long) 1)
                    .build();
            recommendationRepository.save(recommendation2);


            Recommendation recommendation3 = Recommendation.builder()
                    .comment("Good to learn!")
                    .rating(3)
                    .videoId((long) 2)
                    .build();
            recommendationRepository.save(recommendation3);


        };
    }
}
