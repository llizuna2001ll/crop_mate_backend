package com.brogrammers.weatherservice.dto;

import com.brogrammers.weatherservice.models.Current;
import com.brogrammers.weatherservice.models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeatherResponse {
    private Location location;
    private Current current;
    private String humidity;
}
