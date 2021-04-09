package com.rbiedrawa.k8s.app;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Slf4j
    @Service
    static class LogGenerator {

        @Scheduled(fixedDelay = 5_000)
        void generateLog() {
          log.info(String.format("Sample info log%s", UUID.randomUUID()));
        }

        @Scheduled(fixedDelay = 10_000)
        void generateErrorLog() {
            try {
                throw new RuntimeException("Unexpected error:>");
            }catch (Exception ex){
                log.error("Some weird error occurred:D", ex);
            }
        }
    }
}
