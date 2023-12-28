package com.brogrammers.recommendationservice.controllers;


import com.brogrammers.recommendationservice.services.RecommendationBotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/recommendationBot")
public class RecommendationBotController {
    private final RecommendationBotService recommendationBotService;

    public RecommendationBotController(RecommendationBotService recommendationBotService) {
        this.recommendationBotService = recommendationBotService;
    }

    @GetMapping("/crop")
    ResponseEntity<String> chat(@RequestParam Long landId){
        String response = recommendationBotService.chat(landId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
