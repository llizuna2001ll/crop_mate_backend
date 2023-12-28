package com.brogrammers.recommendationservice.entities;

import com.brogrammers.recommendationservice.DTOs.RecommendationRequest;
import com.brogrammers.recommendationservice.enums.AdviceTypes;
import com.brogrammers.recommendationservice.models.Land;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RecommendationId;
    private Long landId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AdviceTypes adviceType;

    @Column(nullable = false)
    private String advice;

    @Transient
    private Land land;

    public static Recommendation toRecommendation(RecommendationRequest recommendationRequest){
        return Recommendation.builder()
                .landId(recommendationRequest.getLandId())
                .build();
    }
}
