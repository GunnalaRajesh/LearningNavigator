package com.example.LearningNavigator.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EController {
    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number)
    {
        RestTemplate restTemplate = new RestTemplate();
        String fact = restTemplate.getForObject(
                "http://numbersapi.com/" + number, String.class);
        return ResponseEntity.ok(fact);
    }
}
