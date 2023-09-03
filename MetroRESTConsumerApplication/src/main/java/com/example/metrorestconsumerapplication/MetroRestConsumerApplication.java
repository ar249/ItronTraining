package com.example.metrorestconsumerapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@SpringBootApplication
public class MetroRestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetroRestConsumerApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
