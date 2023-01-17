package ru.home.lessonMok;

import ru.home.lessonMok.Preference;
import ru.home.lessonMok.PreferencesService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PreferencesServiceMock implements PreferencesService {

    private Map<String, Set<Preference>> preferences = new HashMap<>();

    @Override
    public Set<Preference> get(String userId) {
        return preferences.get(userId);
    }

    public void setPreferences(String id, Set<Preference> preferences) {
        this.preferences.put(id, preferences);
    }
}
