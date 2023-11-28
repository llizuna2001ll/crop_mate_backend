package com.brogrammers.landservice.DTOs;

import com.brogrammers.landservice.entities.Land;
import com.brogrammers.landservice.enums.Levels;
import com.brogrammers.landservice.enums.SoilTypes;
import com.brogrammers.landservice.models.Recommendation;
import com.brogrammers.landservice.models.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * DTO for {@link com.brogrammers.landservice.entities.Land}
 */
@Builder
@Data
public class LandResponse{
    private final Long landId;
    private final Long userId;
    private final String region;
    private final Integer phLevel;
    private final SoilTypes soilType;
    private final Levels nitrogen;
    private final Levels phosphorus;
    private final Levels potassium;
    private final Levels moistureLevel;
    private final Double temperature;
    private final List<Recommendation> recommendation;
    private User user;

    public static LandResponse toLandResponse(Land land){
        return LandResponse.builder()
                .landId(land.getLandId())
                .userId(land.getUserId())
                .region(land.getRegion())
                .phLevel(land.getPhLevel())
                .soilType(land.getSoilType())
                .nitrogen(land.getNitrogen())
                .phosphorus(land.getNitrogen())
                .potassium(land.getPotassium())
                .moistureLevel(land.getMoistureLevel())
                .temperature(land.getTemperature())
                .recommendation(land.getRecommendation())
                .build();
    }
}