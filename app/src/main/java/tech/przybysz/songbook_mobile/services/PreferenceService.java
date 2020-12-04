package tech.przybysz.songbook_mobile.services;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceService {

    private static final String PREFERENCES_FILE = "data";
    private static final int MODE = 0; // MODE_PRIVATE

    private static PreferenceService Instance;
    private final Context appContext;
    private final SharedPreferences preferences;

    private PreferenceService(Context applicationContext) {
        this.appContext = applicationContext;
        this.preferences = appContext.getSharedPreferences(PREFERENCES_FILE, MODE);
    }

    public static PreferenceService init(Context context) {
        Instance = new PreferenceService(context);
        return Instance;
    }

    public static PreferenceService getInstance() {
        if(Instance == null) {
            throw new RuntimeException("PreferenceService was not initialized.");
        }
        return Instance;
    }

    public void setItem(String key, String value) {
        this.preferences.edit().putString(key, value).apply();
    }

    public String getItem(String key) {
        return preferences.getString(key, null);
    }

    public void removeItem(String item) {
        preferences.edit().remove(item).apply();
    }
}
