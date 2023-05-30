package com.example.studytest.webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@Slf4j
public class MyWebClientService {

    public String callApiRestTemplate() {
        StringBuilder sb = new StringBuilder();
        log.info("uri1 call");
        URI uri1 = UriComponentsBuilder
                .fromUriString("http://localhost:8081")
                .path("/api-call1")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate1 = new RestTemplate();
        ResponseEntity<String> resEntity1 = restTemplate1.getForEntity(uri1, String.class);

        log.info("uri2 call");
        URI uri2 = UriComponentsBuilder
                .fromUriString("http://localhost:8081")
                .path("/api-call2")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate2 = new RestTemplate();
        ResponseEntity<String> resEntity2 = restTemplate2.getForEntity(uri2, String.class);

        log.info("uri3 call");
        URI uri3 = UriComponentsBuilder
                .fromUriString("http://localhost:8081")
                .path("/api-call3")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate3 = new RestTemplate();
        ResponseEntity<String> resEntity3 = restTemplate3.getForEntity(uri3, String.class);

        sb.append(resEntity1.getBody());
        sb.append(resEntity2.getBody());
        sb.append(resEntity3.getBody());
        return sb.toString();
    }

    public Mono callApiWebClient() {
        log.info("call ApiWebClient..");
        WebClient webClient = WebClient.create("http://localhost:8081");
        Mono<String> response1 = webClient.get()
                .uri("/api-call1")
                .retrieve()
                .bodyToMono(String.class);

        Mono<String> response2 = webClient.get()
                .uri("/api-call2")
                .retrieve()
                .bodyToMono(String.class);

        Mono<String> response3 = webClient.get()
                .uri("/api-call3")
                .retrieve()
                .bodyToMono(String.class);
        return Mono.zip(response1, response2, response3);
    }

    public String longLatencyApiCall() {
        URI uri1 = UriComponentsBuilder
                .fromUriString("http://localhost:8081")
                .path("/api-call1")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate1 = new RestTemplate();
        restTemplate1.getForEntity(uri1, String.class);
        return "complete!";
    }
}
