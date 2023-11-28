package com.brogrammers.recommendationservice.services;

import com.brogrammers.recommendationservice.DTOs.RecommendationRequest;
import com.brogrammers.recommendationservice.DTOs.RecommendationResponse;

import java.util.List;

public interface RecommendationService {
    RecommendationResponse getRecommendationByLandId(Long landId);
    List<RecommendationResponse> getAllRecommendationsByLandId(Long landId);
    RecommendationResponse addRecommendation(RecommendationRequest recommendationRequest);
    RecommendationResponse updateRecommendation(RecommendationRequest recommendationRequest, Long landId);
    void deleteRecommendation(Long landId);
}
