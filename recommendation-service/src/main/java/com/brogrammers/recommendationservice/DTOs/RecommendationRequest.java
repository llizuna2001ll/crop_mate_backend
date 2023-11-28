package com.brogrammers.recommendationservice.DTOs;

import com.brogrammers.recommendationservice.enums.AdviceTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecommendationRequest {

    @NotBlank(message = "landId should not be empty")
    private Long landId;

    @NotBlank(message = "select a type")
    private AdviceTypes adviceType;

    @NotBlank(message = "advice text should not be empty")
    private String advice;
}
