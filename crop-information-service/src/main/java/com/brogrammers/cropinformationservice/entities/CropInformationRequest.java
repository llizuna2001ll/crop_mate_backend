package com.brogrammers.cropinformationservice.entities;

import com.brogrammers.cropinformationservice.enums.Seasons;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link CropInformation}
 */
@Data
@Builder
public class CropInformationRequest{

    @NotBlank(message = "cropId should not be empty")
    private final Long cropId;

    @NotBlank(message = "cropId should not be empty")
    private final List<Seasons> plantingSeason;

    @NotBlank(message = "cropId should not be empty")
    private final Integer growthDuration;
}