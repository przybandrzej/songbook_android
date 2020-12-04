package tech.przybysz.songbook_mobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executors;

import tech.przybysz.songbook_mobile.activities.FullscreenActivity;
import tech.przybysz.songbook_mobile.activities.LoginActivity;
import tech.przybysz.songbook_mobile.services.AuthService;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Executors.newSingleThreadExecutor().execute(() -> {
            AuthService authService = AuthService.init();
            if (authService.isLoggedIn()) {
                startActivity(new Intent(SplashScreenActivity.this, FullscreenActivity.class));
            } else {
                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
            }
            finish();
        });
    }
}
