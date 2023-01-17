package ru.home.lessonMok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class AdviceServiceTestMock {

    final String ID = "1";
    AdviceService adviceService;
    PreferencesService preferencesService;
    WeatherService weatherService;

    @BeforeEach
    void init() {
        weatherService = Mockito.mock(WeatherService.class);
        preferencesService = Mockito.mock(PreferencesService.class);

        adviceService = new AdviceService(preferencesService, weatherService);
    }

    @Test
    void getAdvice_sunny() {

//        ((WeatherServiceMock) weatherService).setCurrentWeather(Weather.SUNNY);
        Mockito.when(weatherService.currentWeather())
                .thenReturn(Weather.SUNNY);



//        ((PreferencesServiceMock) preferencesService).setPreferences(ID,
//                new HashSet<>(Arrays.asList(Preference.READING, Preference.FOOTBALL)));
        Mockito.when(preferencesService.get(ID))
                .thenReturn(new HashSet<>(Arrays.asList(Preference.READING, Preference.FOOTBALL)));



        Set<Preference> result = adviceService.getAdvice(ID);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(Preference.FOOTBALL, result.iterator().next());
    }

    @Test
    void getAdvice_stormy() {

        ((WeatherServiceMock) weatherService).setCurrentWeather(Weather.STORMY);
        ((PreferencesServiceMock) preferencesService).setPreferences(ID,
                new HashSet<>(Arrays.asList(Preference.READING, Preference.FOOTBALL)));

        Set<Preference> result = adviceService.getAdvice(ID);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(Preference.READING, result.iterator().next());
    }
}