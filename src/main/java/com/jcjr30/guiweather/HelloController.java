package com.jcjr30.guiweather;

import com.jcjr30.backend.geoAPI;
import com.jcjr30.backend.weatherAPI;
import com.jcjr30.backend.API_results;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField searchCity;
    @FXML
    public Button searchButton;

    //"Set" Method Values
    @FXML
    public Label cityState;
    @FXML
    public Text currTemp;
    @FXML
    public Text feelsLikeTemp;
    @FXML
    public Text rainChance;
    @FXML
    public Text humidity;
    @FXML
    public Text windSpeed;
    @FXML
    public Text windDirection;
    @FXML
    public Text dayMaxTemp;
    @FXML
    public Text dayMinTemp;
    @FXML
    public Text dayMaxRainChance;
    @FXML
    public Text Latitude;
    @FXML
    public Text Longitude;

//PREDEFINED
    public static String geoAPIGet;


    @FXML
    public void searchAction() throws IOException, InterruptedException {
        geoAPIGet = searchCity.getText();
        geoAPI.apiRequest(geoAPIGet);
        weatherAPI.apiRequest();
        System.out.println("Setting Values");

        //Current Values
        cityState.setText(API_results.getCity() + ", " + API_results.getState());
        currTemp.setText(API_results.getCurrentTemp() + "°F");
        feelsLikeTemp.setText(API_results.getFeelsLikeTemp() + "°F");
        rainChance.setText(API_results.getRainChance() + "%");
        humidity.setText(API_results.getHumidity() + "%");
        windSpeed.setText(API_results.getWindSpeed() + " mph");
        windDirection.setText(API_results.getWindDirection() + "");

        //Daily Values
        dayMaxTemp.setText(API_results.getDayMaxTemp() + "°F");
        dayMinTemp.setText(API_results.getDayMinTemp() + "°F");
        dayMaxRainChance.setText(API_results.getDayMaxRainChance() + "%");

        //Coordinates
        Latitude.setText(API_results.getLatitude() + "°");
        Longitude.setText(API_results.getLongitude() + "°");
    }

    @FXML
    public void keyPressed(KeyEvent keyEvent) throws IOException, InterruptedException {
        if (keyEvent.getCode() == javafx.scene.input.KeyCode.ENTER)    {
            searchAction();
        }
    }

}