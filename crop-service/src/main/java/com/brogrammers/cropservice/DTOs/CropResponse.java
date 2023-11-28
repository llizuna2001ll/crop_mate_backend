package com.brogrammers.cropservice.DTOs;

import com.brogrammers.cropservice.entities.Crop;
import com.brogrammers.cropservice.enums.CropTypes;
import com.brogrammers.cropservice.models.CropInformation;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.brogrammers.cropservice.entities.Crop}
 */
@Data
@Builder
public class CropResponse{
    Long cropId;
    String name;
    CropTypes cropType;
    CropInformation cropInformation;

    public static CropResponse toCropResponse(Crop crop){
        return CropResponse.builder()
                .cropId(crop.getCropId())
                .name(crop.getName())
                .cropType(crop.getCropType())
                .build();
    }
}