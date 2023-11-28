package com.brogrammers.cropservice.controllers;

import com.brogrammers.cropservice.DTOs.CropRequest;
import com.brogrammers.cropservice.DTOs.CropResponse;
import com.brogrammers.cropservice.services.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crops")
public class CropRestController {

    private final CropService cropService;

    @Autowired
    public CropRestController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<CropResponse> getCropById(@PathVariable Long cropId) {
        CropResponse cropResponse = cropService.getCropById(cropId);
        return new ResponseEntity<>(cropResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CropResponse>> getAllCrops() {
        List<CropResponse> cropResponses = cropService.getAllCrops();
        return new ResponseEntity<>(cropResponses, HttpStatus.OK);
    }

    @PostMapping("/addCrop")
    public ResponseEntity<CropResponse> addCrop(@RequestBody CropRequest cropRequest) {
        CropResponse cropResponse = cropService.addCrop(cropRequest);
        return new ResponseEntity<>(cropResponse, HttpStatus.CREATED);
    }

    @PutMapping("updateCrop/{cropId}")
    public ResponseEntity<CropResponse> updateCrop(@PathVariable Long cropId, @RequestBody CropRequest cropRequest) {
        CropResponse cropResponse = cropService.updateCrop(cropRequest, cropId);
        return new ResponseEntity<>(cropResponse, HttpStatus.OK);
    }

    @DeleteMapping("deleteCrop/{cropId}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long cropId) {
        cropService.deleteCrop(cropId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

