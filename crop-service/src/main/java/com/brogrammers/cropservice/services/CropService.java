package com.brogrammers.cropservice.services;

import com.brogrammers.cropservice.DTOs.CropRequest;
import com.brogrammers.cropservice.DTOs.CropResponse;

import java.util.List;

public interface CropService {

    CropResponse getCropById(Long cropId);
    List<CropResponse> getAllCrops();
    CropResponse addCrop(CropRequest cropRequest);
    CropResponse updateCrop(CropRequest cropRequest, Long cropId);
    void deleteCrop(Long cropId);
}
