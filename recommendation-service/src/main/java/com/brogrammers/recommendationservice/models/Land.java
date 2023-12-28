package com.brogrammers.recommendationservice.models;

import com.brogrammers.recommendationservice.enums.Levels;
import com.brogrammers.recommendationservice.enums.SoilTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Land {
    private Long landId;
    private Long userId;
    private String region;
    private Integer phLevel;
    private SoilTypes soilType;
    private Levels nitrogen;
    private Levels phosphorus;
    private Levels potassium;
    private Levels moistureLevel;
    private Double temperature;
}
