package com.sensoriainc.dagger2tutorial.data;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zep on 23/01/18.
 */

@Singleton
public class SharedPrefsHelper {
    public static String PREF_KEY_ACCESS_TOKEN = "access-token";

    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefsHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public int get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }
    public float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }
    public boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }
    public void deleteSavedData(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }
}
