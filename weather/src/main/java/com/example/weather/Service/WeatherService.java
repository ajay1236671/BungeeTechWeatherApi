package com.example.weather.Service;

import com.example.weather.Model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${OPENWEATHER_API_KEY}")
    private String apiKey;

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherResponse getWeather(String city) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?q=%s&appid=%s", BASE_URL, city, apiKey);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
