package com.brogrammers.weatherservice.web;

import com.brogrammers.weatherservice.dto.WeatherResponse;
import com.brogrammers.weatherservice.services.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherRestController {
    private final WeatherService weatherService;

    public WeatherRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    ResponseEntity<WeatherResponse> getWeather(@RequestParam String location){
        WeatherResponse weatherResponse = weatherService.getWeather(location);
        return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
    }
}
