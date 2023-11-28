package com.brogrammers.userservice.models;

import com.brogrammers.userservice.enums.Levels;
import com.brogrammers.userservice.enums.SoilTypes;
import lombok.Data;

@Data
public class Land {
    private Long landId;
    private String region;
    private Integer phLevel;
    private SoilTypes soilType;
    private Levels nitrogen;
    private Levels phosphorus;
    private Levels potassium;
    private Levels moistureLevel;
    private Double temperature;
}
