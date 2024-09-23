package com.example.weather.Controller;

import com.example.weather.Model.WeatherResponse;
import com.example.weather.Service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = weatherService.getWeather(city);
        } catch (Exception e) {
            model.addAttribute("api_error", e.getMessage());
        }
        if (weatherResponse != null) {
            model.addAttribute("weather", weatherResponse);
        } else {
            model.addAttribute("error", "Could not retrieve weather data.");
        }
        return "index";
    }
}
