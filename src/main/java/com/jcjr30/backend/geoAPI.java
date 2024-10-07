package com.jcjr30.backend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;



public class geoAPI {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    //Gets latitude, longitude, and state from city input
    public static void apiRequest(String geoReq) throws IOException, InterruptedException {

        String geoLocation = ("https://geocoding-api.open-meteo.com/v1/search?name=" + geoReq + "&count=1&language=en&format=json");
        System.out.println("Accessing: " + geoLocation);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest geoRequest = HttpRequest.newBuilder()
                .uri(URI.create(geoLocation))
                .GET()
                .build();
        HttpResponse<String> response = client.send(geoRequest, HttpResponse.BodyHandlers.ofString());

        //read JSON to JsonNode
        JsonNode node = objectMapper.readTree(response.body());
        node.path("results");

        //Create variables with JsonNode
        String city = node.findPath("name").toString();
        String state = node.findPath("admin1").toString();
        double lat = node.findPath("latitude").asDouble();
        double lng = node.findPath("longitude").asDouble();

        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Latitude: " + lat);
        System.out.println("Longitude: " + lng);

        //Set variables in results class
        API_results.setAllGeo(city, state, lat, lng);

    }

}
