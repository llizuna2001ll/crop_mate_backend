package com.brogrammers.recommendationservice.services;

import com.brogrammers.recommendationservice.DTOs.RecommendationRequest;
import com.brogrammers.recommendationservice.DTOs.RecommendationResponse;
import com.brogrammers.recommendationservice.entities.Recommendation;
import com.brogrammers.recommendationservice.repositories.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Autowired
    public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public RecommendationResponse getRecommendationByLandId(Long landId) {
        return RecommendationResponse.toRecommendationResponse(recommendationRepository.getRecommendationByLandId(landId));
    }

    @Override
    public List<RecommendationResponse> getAllRecommendationsByLandId(Long landId) {
        List<RecommendationResponse> recommendationResponses = new ArrayList<>();
        List<Recommendation> recommendations = recommendationRepository.getAllByLandId(landId);
        for (Recommendation recommendation : recommendations){
            recommendationResponses.add(RecommendationResponse.toRecommendationResponse(recommendation));
        }
        return recommendationResponses;
    }

    @Override
    public RecommendationResponse addRecommendation(RecommendationRequest recommendationRequest) {
        return RecommendationResponse.toRecommendationResponse(recommendationRepository.save(Recommendation.toRecommendation(recommendationRequest)));
    }

    @Override
    public RecommendationResponse updateRecommendation(RecommendationRequest recommendationRequest, Long landId) {
        return null;
    }

    @Override
    public void deleteRecommendation(Long recommendationId) {
        recommendationRepository.deleteById(recommendationId);
    }
}
