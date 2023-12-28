package com.brogrammers.recommendationservice.controllers;

import com.brogrammers.recommendationservice.models.Land;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "LAND-SERVICE")
public interface LandRestClient {
    @GetMapping("api/v1/lands/{landId}")
    Land getLandById(@PathVariable("landId") Long landId);
}
