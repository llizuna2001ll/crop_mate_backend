package com.brogrammers.recommendationservice.services;


import com.brogrammers.recommendationservice.DTOs.ChatGPTRequest;
import com.brogrammers.recommendationservice.DTOs.ChatGPtResponse;
import com.brogrammers.recommendationservice.controllers.LandRestClient;
import com.brogrammers.recommendationservice.models.Land;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecommendationBotServiceImpl implements RecommendationBotService {

    private final String CROP_RECOMMENDATION_JSON = "[{order, cropArabicName, cropFrenchName, cropEnglishName,reasonWhyArabic,reasonWhyEnglish,reasonWhyFrench}]";

    private final LandRestClient landRestClient;

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    private final RestTemplate template;

    public RecommendationBotServiceImpl(LandRestClient landRestClient, RestTemplate template) {
        this.landRestClient = landRestClient;
        this.template = template;
    }

    @Override
    public String chat(Long landId) {
        Land land = landRestClient.getLandById(landId);
        ChatGPTRequest request = getGptRequest(land);
        ChatGPtResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPtResponse.class);
        assert chatGptResponse != null : "No response found";
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }

    private ChatGPTRequest getGptRequest(Land land) {
        String prompt = "Nitrogen: "+ land.getNitrogen() +" Phosphorus: "+ land.getPhosphorus()
                +" Potassium: " + land.getPotassium()
                +" Temperature: " + land.getTemperature()
                + "°C Moisture: " + land.getMoistureLevel()
                + "% PH level: "+ land.getPhLevel()
                + " As an agricultural engineer and give me list in order of best crops for these conditions answer with json like this "+CROP_RECOMMENDATION_JSON;
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        return request;
    }
}
