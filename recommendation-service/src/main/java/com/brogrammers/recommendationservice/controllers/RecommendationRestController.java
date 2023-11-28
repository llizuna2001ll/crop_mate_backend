package com.brogrammers.recommendationservice.controllers;

import com.brogrammers.recommendationservice.DTOs.RecommendationRequest;
import com.brogrammers.recommendationservice.DTOs.RecommendationResponse;
import com.brogrammers.recommendationservice.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendations")
public class RecommendationRestController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationRestController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{landId}")
    public ResponseEntity<RecommendationResponse> getRecommendationByLandId(@PathVariable Long landId) {
        RecommendationResponse response = recommendationService.getRecommendationByLandId(landId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/{landId}")
    public ResponseEntity<List<RecommendationResponse>> getAllRecommendationsByLandId(@PathVariable Long landId) {
        List<RecommendationResponse> responses = recommendationService.getAllRecommendationsByLandId(landId);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/addRecommendation")
    public ResponseEntity<RecommendationResponse> addRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
        RecommendationResponse response = recommendationService.addRecommendation(recommendationRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{recommendationId}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Long recommendationId) {
        recommendationService.deleteRecommendation(recommendationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

