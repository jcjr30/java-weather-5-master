package com.jcjr30.backend;

public class API_results {

    //Current weather variables
    private static double currentTemp;
    private static double feelsLikeTemp;
    private static double rainChance;
    private static double humidity;
    private static double windSpeed;
    private static int windDirection;

    //Daily weather variables
    private static double dayMaxTemp;
    private static double dayMinTemp;
    private static double dayMaxRainChance;


    //geoAPI variables
    private static String name;
    private static String admin1;
    private static double latitude;
    private static double longitude;


    //GET API VARIABLES


    //Combines all setGeo methods
    public static void setAllGeo(String name, String admin1, double latitude, double longitude)  {
        setCity(name);
        setState(admin1);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    //Set and get City name
    private static void setCity(String city) {
        name = city;
    }
    public static String getCity() {
        System.out.println("City: " + name);
        return name;
    }

    //Set and get State(admin1) name
    private static void setState(String state)  {
        admin1 = state;
    }
    public static String getState()    {
        return admin1;
    }

    //Set and get Latitude
    private static void setLatitude(double lat)  {
        latitude = lat;
    }
    public static double getLatitude()    {
        return latitude;
    }
    //Set and get Longitude
    private static void setLongitude(double lng)  {
        longitude = lng;
    }
    public static double getLongitude()    {
        return longitude;
    }


    //WEATHER API VARIABLES

    //Set all current weather variables
    public static void setAllCurrentWeather(double currTemp, double feelsLike, double rain_chance, double humid, double windSpd, int windDirect)  {
        setCurrentTemp(currTemp);
        setFeelsLikeTemp(feelsLike);
        setRainChance(rain_chance);
        setHumidity(humid);
        setWindSpeed(windSpd);
        setWindDirection(windDirect);
    }

    //Set and get current weather variables
    private static void setCurrentTemp(double currTemp)    {
        currentTemp = currTemp;
    }
    public static double getCurrentTemp()   {
        return currentTemp;
    }
    private static void setFeelsLikeTemp(double feelsLike)    {
        feelsLikeTemp = feelsLike;
    }
    public static double getFeelsLikeTemp()   {
        return feelsLikeTemp;
    }
    private static void setRainChance(double rain_chance)    {
        rainChance = rain_chance;
    }
    public static double getRainChance()   {
        return rainChance;
    }
    private static void setHumidity(double humid)    {
        humidity = humid;
    }
    public static double getHumidity()   {
        return humidity;
    }
    private static void setWindSpeed(double windSpd)    {
        windSpeed = windSpd;
    }
    public static double getWindSpeed()   {
        return windSpeed;
    }
    private static void setWindDirection(int windDirect)    {
        windDirection = windDirect;
    }
    public static double getWindDirection()   {
        return windDirection;
    }

    //Set all daily weather variables
    public static void setAllDailyWeather(double dayMax, double dayMin, double dayRainMax) {
        setDayMaxTemp(dayMax);
        setDayMinTemp(dayMin);
        setDayMaxRainChance(dayRainMax);
    }

    //Daily weather variables
    private static void setDayMaxTemp(double dayMax)    {
        dayMaxTemp = dayMax;
    }
    public static double getDayMaxTemp()   {
        return dayMaxTemp;
    }
    private static void setDayMinTemp(double dayMin)    {
        dayMinTemp = dayMin;
    }
    public static double getDayMinTemp()   {
        return dayMinTemp;
    }
    private static void setDayMaxRainChance(double dayRainMax)    {
        dayMaxRainChance = dayRainMax;
    }
    public static double getDayMaxRainChance()   {
        return dayMaxRainChance;
    }
}
