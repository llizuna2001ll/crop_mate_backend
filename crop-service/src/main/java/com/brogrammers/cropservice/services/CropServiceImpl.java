package com.brogrammers.cropservice.services;

import com.brogrammers.cropservice.DTOs.CropRequest;
import com.brogrammers.cropservice.DTOs.CropResponse;
import com.brogrammers.cropservice.entities.Crop;
import com.brogrammers.cropservice.exceptions.CropNotFoundException;
import com.brogrammers.cropservice.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Autowired
    public CropServiceImpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public CropResponse getCropById(Long cropId) {
        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new CropNotFoundException("Crop not found with ID: " + cropId));
        return CropResponse.toCropResponse(crop);
    }

    @Override
    public List<CropResponse> getAllCrops() {
        List<Crop> crops = cropRepository.findAll();
        List<CropResponse> cropResponses = new ArrayList<>();
        for(Crop crop : crops)
            cropResponses.add(CropResponse.toCropResponse(crop));

        return cropResponses;
    }

    @Override
    public CropResponse addCrop(CropRequest cropRequest) {
        Crop crop = Crop.toCrop(cropRequest);
        Crop savedCrop = cropRepository.save(crop);
        return CropResponse.toCropResponse(savedCrop);
    }

    @Override
    public CropResponse updateCrop(CropRequest cropRequest, Long cropId) {
        Crop existingCrop = cropRepository.findById(cropId)
                .orElseThrow(() -> new CropNotFoundException("Crop not found with ID: " + cropId));

        existingCrop.setName(cropRequest.getName());
        existingCrop.setCropType(cropRequest.getCropType());

        Crop updatedCrop = cropRepository.save(existingCrop);
        return CropResponse.toCropResponse(updatedCrop);
    }

    @Override
    public void deleteCrop(Long cropId) {
        cropRepository.deleteById(cropId);
    }

}
