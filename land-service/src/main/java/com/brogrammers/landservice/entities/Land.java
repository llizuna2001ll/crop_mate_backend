package com.brogrammers.landservice.entities;

import com.brogrammers.landservice.DTOs.LandRequest;
import com.brogrammers.landservice.enums.Levels;
import com.brogrammers.landservice.enums.SoilTypes;
import com.brogrammers.landservice.models.Crop;
import com.brogrammers.landservice.models.Recommendation;
import com.brogrammers.landservice.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long landId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private Integer phLevel;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SoilTypes soilType;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Levels nitrogen;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Levels phosphorus;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Levels potassium;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Levels moistureLevel;

    @Column(nullable = false)
    private Double temperature;


    @Transient
    private List<Crop> recommendedCrops;
    @Transient
    private List<Recommendation> recommendation;
    @Transient
    private User user;

    public static Land toLand(LandRequest landRequest){
        return Land.builder()
                .userId(landRequest.getUserId())
                .region(landRequest.getRegion())
                .phLevel(landRequest.getPhLevel())
                .soilType(landRequest.getSoilType())
                .nitrogen(landRequest.getNitrogen())
                .phosphorus(landRequest.getNitrogen())
                .potassium(landRequest.getPotassium())
                .moistureLevel(landRequest.getMoistureLevel())
                .temperature(landRequest.getTemperature())
                .build();
    }
}
