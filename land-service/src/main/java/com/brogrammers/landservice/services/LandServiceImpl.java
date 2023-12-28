package com.brogrammers.landservice.services;

import com.brogrammers.landservice.DTOs.LandRequest;
import com.brogrammers.landservice.DTOs.LandResponse;
import com.brogrammers.landservice.entities.Land;
import com.brogrammers.landservice.repositories.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandServiceImpl implements LandService {

    private final LandRepository landRepository;

    @Autowired
    public LandServiceImpl(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    @Override
    public LandResponse getLandById(Long landId) {
        return LandResponse.toLandResponse(landRepository.findById(landId).orElseThrow(()-> new RuntimeException("Land Not Found")));
    }

    @Override
    public List<LandResponse> getAllLandsByUserId(Long userId) {
        List<LandResponse> landResponses = new ArrayList<>();
        List<Land> lands = landRepository.findAllByUserId(userId);
        for (Land land : lands) {
            landResponses.add(LandResponse.toLandResponse(land));
        }
        return landResponses;
    }

    @Override
    public LandResponse addLand(LandRequest landRequest) {
        return LandResponse.toLandResponse(landRepository.save(Land.toLand(landRequest)));
    }

    @Override
    public LandResponse updateLand(LandRequest landRequest, Long landId) {
        Land existingLand = landRepository.findById(landId).orElseThrow(() -> new RuntimeException("Land Not Found!"));

        existingLand.setRegion(landRequest.getRegion());
        existingLand.setPhLevel(landRequest.getPhLevel());
        existingLand.setSoilType(landRequest.getSoilType());
        existingLand.setNitrogen(landRequest.getNitrogen());
        existingLand.setPhosphorus(landRequest.getPhosphorus());
        existingLand.setPotassium(landRequest.getPotassium());
        existingLand.setMoistureLevel(landRequest.getMoistureLevel());
        existingLand.setTemperature(landRequest.getTemperature());

        return LandResponse.toLandResponse(landRepository.save(existingLand));
    }


    @Override
    public void deleteLand(Long landId) {
        landRepository.deleteById(landId);
    }
}
