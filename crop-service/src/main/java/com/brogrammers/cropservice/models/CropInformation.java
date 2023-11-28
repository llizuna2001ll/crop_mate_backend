package com.brogrammers.cropservice.models;

import com.brogrammers.cropservice.enums.Seasons;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CropInformation {
    private Long cropInformationId;
    private List<Seasons> plantingSeasons;
    private Integer growthDuration;
}
