package com.example.studytest.request;

import com.example.studytest.request.dto.RequestDtoV1;
import com.example.studytest.request.dto.RequestDtoV2;
import com.example.studytest.request.dto.RequestDtoV3;
import com.example.studytest.request.dto.RequestDtoV4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class RequestController {

    @PostMapping("/api/v1/request-body")
    public void requestBodyTestV1(@RequestBody RequestDtoV1 body, HttpServletRequest request) {
        log.info("call requestBodyTestV1");
        log.info("body = {}", body.toString());
    }

    @PostMapping("/api/v1/model-attribute")
    public void ModelAttributeTestV1(@ModelAttribute RequestDtoV1 body) {
        log.info("call ModelAttributeTestV1");
        log.info("body = {}", body.toString());
    }

    @PostMapping("/api/v2/request-body")
    public void requestBodyTestV2(@RequestBody RequestDtoV2 body) {
        log.info("call requestBodyTestV2");
        log.info("body.id = {}", body.getId());
        log.info("body.name = {}", body.getName());
    }

    @PostMapping("/api/v2/model-attribute")
    public void ModelAttributeTestV2(@ModelAttribute RequestDtoV2 body) {
        log.info("call ModelAttributeTestV2");
        log.info("body.id = {}", body.getId());
        log.info("body.name = {}", body.getName());
    }

    @PostMapping("/api/v3/request-body")
    public void requestBodyTestV3(@RequestBody RequestDtoV3 body) {
        log.info("call requestBodyTestV3");
        log.info("body = {}", body.toString());
    }

    @PostMapping("/api/v3/model-attribute")
    public void ModelAttributeTestV3(@ModelAttribute RequestDtoV3 body) {
        log.info("call ModelAttributeTestV3");
        log.info("body = {}", body.toString());
    }

    @PostMapping("/api/v4/request-body")
    public void requestBodyTestV4(@RequestBody RequestDtoV4 body) {
        log.info("call requestBodyTestV4");
        log.info("body.id = {}", body.getId());
        log.info("body.name = {}", body.getName());
    }

    @PostMapping("/api/v4/model-attribute")
    public void ModelAttributeTestV4(@ModelAttribute RequestDtoV4 body) {
        log.info("call ModelAttributeTestV4");
        log.info("body.id = {}", body.getId());
        log.info("body.name = {}", body.getName());
    }

    @ModelAttribute
    public String modelAttributeTest() {
        return "model";
    }

}
