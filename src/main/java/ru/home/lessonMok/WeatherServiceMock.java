package ru.home.lessonMok;

import ru.home.lessonMok.Weather;
import ru.home.lessonMok.WeatherService;

public class WeatherServiceMock implements WeatherService {

    private Weather currentWeather;

    @Override
    public Weather currentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(Weather currentWeather) {
        this.currentWeather = currentWeather;
    }
}
