package com.brogrammers.landservice.services;

import com.brogrammers.landservice.DTOs.LandRequest;
import com.brogrammers.landservice.DTOs.LandResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LandService {
    LandResponse getLandByUserId(Long userId);
    List<LandResponse> getAllLandsByUserId(Long userId);
    LandResponse addLand(LandRequest landRequest);
    LandResponse updateLand(LandRequest landRequest, Long landId);
    void deleteLand(Long landId);
}
