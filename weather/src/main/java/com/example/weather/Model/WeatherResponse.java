package com.example.weather.Model;

// WeatherResponse.java

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    private String city;
    private String description;
    private double temperature;

    public WeatherResponse(@JsonProperty("name") String city,
                           @JsonProperty("weather") Weather[] weather,
                           @JsonProperty("main") Main main) {
        this.city = city;
        this.description = weather[0].getDescription();
        this.temperature = main.getTemp();
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public double getTemperature() {
        return temperature;
    }

    // Getters and setters...

    private static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }
    }

    private static class Main {
        private double temp;

        public double getTemp() {
            return temp;
        }
    }
}

