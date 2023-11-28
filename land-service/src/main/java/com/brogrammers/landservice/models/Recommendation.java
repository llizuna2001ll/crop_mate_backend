package com.brogrammers.landservice.models;

import com.brogrammers.landservice.enums.AdviceTypes;
import lombok.Data;

@Data
public class Recommendation {
    private Long recommendationId;
    private AdviceTypes adviceType;
    private String advice;
}
