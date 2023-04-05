package com.example.Service_A_logging;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/greeting")
@Slf4j
public class CallerB {
    private final RestTemplate restTemplate;
    public CallerB(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String greeting(){
        String bResponse = restTemplate.getForObject("http://service-b-logging/greeting", String.class);
        log.info("Hello message from A");
        return bResponse;
    }
}
