package com.brogrammers.weatherservice.web;

import com.brogrammers.weatherservice.dto.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.weatherapi.com/v1", name = "external-api")
public interface WeatherApiRestClient {
    @GetMapping("/current.json")
    WeatherResponse getWeather(@RequestParam("q") String q, @RequestParam("key") String key);
}