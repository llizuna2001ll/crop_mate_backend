package com.brogrammers.landservice.DTOs;

import com.brogrammers.landservice.enums.Levels;
import com.brogrammers.landservice.enums.SoilTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LandRequest {
    private Long userId;

    @NotBlank(message = "Fill the location field!")
    private String region;

    @NotBlank(message = "pH level should not be empty!")
    private Integer phLevel;

    @NotBlank(message = "soil type should not be empty!")
    private SoilTypes soilType;

    @NotBlank(message = "nitrogen should not be empty!")
    private Levels nitrogen;

    @NotBlank(message = "phosphorus should not be empty!")
    private Levels phosphorus;

    @NotBlank(message = "potassium should not be empty!")
    private Levels potassium;

    @NotBlank(message = "moisture should not be empty!")
    private Levels moistureLevel;

    @NotBlank(message = "temperature should not be empty!")
    private Double temperature;

}
