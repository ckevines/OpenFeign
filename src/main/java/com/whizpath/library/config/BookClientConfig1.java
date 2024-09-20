package com.whizpath.library.config;

import com.whizpath.library.decoder.FeignErrorDecorder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BookClientConfig1 {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptorBookService1(
            @Value("${book-service-client1.username}") String username,
            @Value("${book-service-client1.password}") String password
    ) {
        BasicAuthenticationInterceptor basicAuthenticationInterceptor = new BasicAuthenticationInterceptor(username, password);
        return basicAuthenticationInterceptor;
    }

    @Bean
    public RequestInterceptor requestInterceptor(
            @Value("${book-service-client1.username}") String username,
            @Value("${book-service-client1.password}") String password
    ) {
        return requestTemplate -> {
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
            String authHeader = "Basic " + new String(encodedAuth);
            requestTemplate.header("user", username);
            requestTemplate.header("password", password);
            requestTemplate.header("Authorization", authHeader);
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecorder();
    }
}
