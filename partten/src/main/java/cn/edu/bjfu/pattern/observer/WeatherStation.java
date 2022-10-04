package cn.edu.bjfu.pattern.observer;

import cn.edu.bjfu.pattern.observer.CurrentConditionDisplay;
import cn.edu.bjfu.pattern.observer.WeatherData;

/**
 * @author chaos
 * @date 2022-09-22 21:42
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(20,12,30);
    }
}
