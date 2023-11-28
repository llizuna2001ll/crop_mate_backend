package com.brogrammers.recommendationservice.DTOs;

import com.brogrammers.recommendationservice.entities.Recommendation;
import com.brogrammers.recommendationservice.enums.AdviceTypes;
import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link Recommendation}
 */
@Data
@Builder
public class RecommendationResponse {
    private Long RecommendationId;
    private Long landId;
    private AdviceTypes adviceType;
    private String advice;

    public static RecommendationResponse toRecommendationResponse(Recommendation recommendation){
        return RecommendationResponse.builder()
                .RecommendationId(recommendation.getRecommendationId())
                .landId(recommendation.getLandId())
                .adviceType(recommendation.getAdviceType())
                .advice(recommendation.getAdvice())
                .build();
    }
}