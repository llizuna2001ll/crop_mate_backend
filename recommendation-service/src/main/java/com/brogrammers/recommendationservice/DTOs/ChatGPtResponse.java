package com.brogrammers.recommendationservice.DTOs;

import com.brogrammers.recommendationservice.models.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPtResponse {
    private List<Choice> choices;
}
