package Challange2;

public class Temperature {

    public static float celsiusToFahrenheit(float temperature){
        return (temperature * 9/5) + 32;
    }
    public static float celsiusToKelvin(float temperature){
        return temperature + 273.15f;
    }

    public static float fahrenheitToCelsius(float temperature){
        return (temperature -32) * 5/9;
    }

    public static float kelvinToCelsius(float temperature){
        return temperature - 273.15f;
    }
}
