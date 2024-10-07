package com.jcjr30.backend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class weatherAPI {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void apiRequest() throws IOException, InterruptedException {

        double lat = API_results.getLatitude();
        double lng = API_results.getLongitude();
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lng + "&current=temperature_2m,relative_humidity_2m,apparent_temperature,precipitation,wind_speed_10m,wind_direction_10m&daily=temperature_2m_max,temperature_2m_min,precipitation_probability_max&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch&timezone=America%2FChicago&forecast_days=1&models=gfs_seamless";

        System.out.println("Accessing: " + url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest geoRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(geoRequest, HttpResponse.BodyHandlers.ofString());

        JsonNode node = objectMapper.readTree(response.body());
        JsonNode dailyNode = objectMapper.readTree(response.body());

        //Current weather variables
        double currentTemp = node.path("current").get("temperature_2m").asDouble();
        double feelsLikeTemp = node.path("current").get("apparent_temperature").asDouble();
        double rainChance = node.path("current").get("precipitation").asDouble();
        double humidity = node.path("current").get("relative_humidity_2m").asDouble();
        double windSpeed = node.path("current").get("wind_speed_10m").asDouble();
        int windDirection = node.path("current").get("wind_direction_10m").asInt();

        //Daily weather variables
        String tempMaxTemp = dailyNode.path("daily").get("temperature_2m_max").toString();
        String tempMinTemp = dailyNode.path("daily").get("temperature_2m_min").toString();
        String tempMaxRainChance = dailyNode.path("daily").get("precipitation_probability_max").toString();
        tempMaxTemp = tempMaxTemp.replace("[", "");
        tempMaxTemp = tempMaxTemp.replace("]", "");
        tempMinTemp = tempMinTemp.replace("[", "");
        tempMinTemp = tempMinTemp.replace("]", "");
        tempMaxRainChance = tempMaxRainChance.replace("[", "");
        tempMaxRainChance = tempMaxRainChance.replace("]", "");
        double maxTemp = Double.parseDouble(tempMaxTemp);
        double minTemp = Double.parseDouble(tempMinTemp);
        double maxRainChance = Double.parseDouble(tempMaxRainChance);

        System.out.println("Current Temperature: " + currentTemp + "°F");
        System.out.println("Feels Like Temperature: " + feelsLikeTemp + "°F");
        System.out.println("Current Chance of Rain: " + rainChance + " %");
        System.out.println("Current Humidity " + humidity + " %");
        System.out.println("Current Wind Speed: " + windSpeed + " mp/h");
        System.out.println("Current Wind Direction: " + windDirection + "°");
        System.out.println("For Today:");
        System.out.println("Max Temperature: " + maxTemp + "°F");
        System.out.println("Min Temperature: " + minTemp + "°F");
        System.out.println("Max Rain Chance: " + maxRainChance + " %");

        //Sets all variables in API_results class
        API_results.setAllCurrentWeather(currentTemp, feelsLikeTemp, rainChance, humidity, windSpeed, windDirection);
        API_results.setAllDailyWeather(maxTemp, minTemp, maxRainChance);
    }
}
