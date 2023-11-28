package com.brogrammers.landservice.models;

import com.brogrammers.landservice.enums.CropTypes;
import lombok.Data;

@Data
public class Crop {
    private Long cropId;
    private String name;
    private CropTypes type;
}
