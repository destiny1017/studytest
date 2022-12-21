package com.example.studytest.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CacheController {

    private final CacheService cacheService;

    @GetMapping("/api/execute/{num}")
    @Cacheable("cache")
    public String execute(@PathVariable int num) {
        log.info("execute api call");
        String result = cacheService.execute(num);
        return result;
    }

    @PutMapping("/api/execute/{num}/{data}")
    @CacheEvict(value = "cache", key = "#num")
    public void changeData(@PathVariable int num, @PathVariable String data) {
        cacheService.changeData(num, data);
        log.info("deleted num[{}] cacheData..", num);
    }

}
