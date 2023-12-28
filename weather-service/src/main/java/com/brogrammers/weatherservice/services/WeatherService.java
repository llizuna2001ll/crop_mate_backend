package com.brogrammers.weatherservice.services;

import com.brogrammers.weatherservice.dto.WeatherResponse;
import com.brogrammers.weatherservice.web.WeatherApiRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiRestClient weatherApiRestClient;

    @Value("${app.weather.secret-key}")
    private String key;

    @Autowired
    public WeatherService(WeatherApiRestClient weatherRestClient) {
        this.weatherApiRestClient = weatherRestClient;
    }

    public WeatherResponse getWeather(String location){
        return weatherApiRestClient.getWeather(location, key);
    }
}
