package com.brogrammers.cropinformationservice.entities;

import com.brogrammers.cropinformationservice.enums.Seasons;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class CropInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cropInformationId;

    @Column(nullable = false)
    private Long cropId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Seasons> plantingSeason;

    @Column(nullable = false)
    private Integer growthDuration;

}
