package com.example.studytest.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
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
        return response.block().toString();
    }
}
