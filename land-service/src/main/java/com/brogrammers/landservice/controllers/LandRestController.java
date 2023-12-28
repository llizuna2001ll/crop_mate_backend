package com.brogrammers.landservice.controllers;

import com.brogrammers.landservice.DTOs.LandRequest;
import com.brogrammers.landservice.DTOs.LandResponse;
import com.brogrammers.landservice.services.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lands")
public class LandRestController {

    private final LandService landService;

    @Autowired
    public LandRestController(LandService landService) {
        this.landService = landService;
    }

    @GetMapping("/{landId}")
    public ResponseEntity<LandResponse> getLandById(@PathVariable Long landId) {
        LandResponse landResponse = landService.getLandById(landId);
        return new ResponseEntity<>(landResponse, HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<LandResponse>> getAllLandsByUserId(@PathVariable Long userId) {
        List<LandResponse> landResponses = landService.getAllLandsByUserId(userId);
        return new ResponseEntity<>(landResponses, HttpStatus.OK);
    }

    @PostMapping("/addLand")
    public ResponseEntity<LandResponse> addLand(@RequestBody LandRequest landRequest) {
        LandResponse landResponse = landService.addLand(landRequest);
        return new ResponseEntity<>(landResponse, HttpStatus.CREATED);
    }

    @PutMapping("updateLand/{landId}")
    public ResponseEntity<LandResponse> updateLand(@RequestBody LandRequest landRequest, @PathVariable Long landId) {
        LandResponse landResponse = landService.updateLand(landRequest, landId);
        return new ResponseEntity<>(landResponse, HttpStatus.OK);
    }

    @DeleteMapping("deleteLand/{landId}")
    public ResponseEntity<Void> deleteLand(@PathVariable Long landId) {
        landService.deleteLand(landId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
