package com.brogrammers.cropservice.entities;

import com.brogrammers.cropservice.DTOs.CropRequest;
import com.brogrammers.cropservice.enums.CropTypes;
import com.brogrammers.cropservice.models.CropInformation;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CropTypes cropType;

    @Transient
    private CropInformation cropInformation;

    public static Crop toCrop(CropRequest cropRequest){
        return Crop.builder()
                .name(cropRequest.getName())
                .cropType(cropRequest.getCropType())
                .build();
    }
}
