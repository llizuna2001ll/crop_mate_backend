package com.brogrammers.cropservice.DTOs;

import com.brogrammers.cropservice.entities.Crop;
import com.brogrammers.cropservice.enums.CropTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Crop}
 */
@Data
public class CropRequest {

    @NotBlank(message = "name should not be empty")
    private String name;

    @NotBlank(message = "select a crop category")
    private CropTypes cropType;
}