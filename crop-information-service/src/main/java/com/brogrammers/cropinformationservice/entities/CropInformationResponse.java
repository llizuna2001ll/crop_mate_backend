package com.brogrammers.cropinformationservice.entities;

import com.brogrammers.cropinformationservice.enums.Seasons;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * DTO for {@link CropInformation}
 */
@Data
@Builder
public class CropInformationResponse {
    private final Long cropInformationId;
    private final Long cropId;
    private final List<Seasons> plantingSeason;
    private final Integer growthDuration;

}