package com.example.astrorehber;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "AstroSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_EMAIL = "email";

    private static final String KEY_FULL_NAME = "fullName";

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    // Kullanıcı giriş yaptığında oturumu kaydet
    public void createLoginSession(String email, String fullName) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_FULL_NAME, fullName);
        editor.apply();
    }

    public String getFullName() {
        return prefs.getString(KEY_FULL_NAME, "Gezgin");
    }

    // Giriş yapılmış mı kontrol et
    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // Oturumu Kapat (Çıkış Yap)
    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
}