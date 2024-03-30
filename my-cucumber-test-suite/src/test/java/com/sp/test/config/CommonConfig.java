package com.sp.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class CommonConfig {
    public RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:8990")
            .build();
}
