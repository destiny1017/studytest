package com.example.studytest.webclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyWebClientController {

    private final MyWebClientService myWebClientService;

    @GetMapping("/rt-call")
    public String rtCall() {
        String response = myWebClientService.callApiRestTemplate();
        return response;
    }

    @GetMapping("/wc-call")
    public String wcCall() {
        Mono response = myWebClientService.callApiWebClient();
        log.info("end ApiWebClient..");
        return response.block().toString();
    }

    @GetMapping("/multi-request")
    public String multi() {
        log.info("api started");
        String response = myWebClientService.longLatencyApiCall();
        log.info("api end");
        return response;
    }
}
