package tech.przybysz.songbook_mobile.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executors;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.services.AuthService;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            loginButton.setVisibility(View.GONE);
            usernameEditText.setEnabled(false);
            passwordEditText.setEnabled(false);
            String pass = passwordEditText.getText().toString();
            String login = usernameEditText.getText().toString();
            if (pass == null || pass.trim().isEmpty() || login == null || login.trim().isEmpty()) {
                return;
            }
            Executors.newSingleThreadExecutor().execute(() -> {
                AuthService.getInstance().signIn(login, pass, false)
                        .subscribe(userDTO -> {
                                    new Handler(Looper.getMainLooper()).post(() -> {
                                        updateUiWithUser(userDTO);
                                    });
                                },
                                error -> {
                                    new Handler(Looper.getMainLooper()).post(() -> showLoginFailed(R.string.login_failed));
                                });
            });
        });
    }

    private void updateUiWithUser(UserDTO model) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}