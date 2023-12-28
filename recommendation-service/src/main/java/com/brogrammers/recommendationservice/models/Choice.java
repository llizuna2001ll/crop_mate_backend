package com.brogrammers.recommendationservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Choice {
    private int index ;
    private Message message;
}