package tech.przybysz.songbook_mobile.activities;

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

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.api_client.domain.LoginForm;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.api_client.rest.AuthenticationResourceApi;
import tech.przybysz.songbook_mobile.services.AuthService;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginButton.setOnClickListener(v -> {
            Log.d("OnClick", "login");
            loadingProgressBar.setVisibility(View.VISIBLE);
            String pass = passwordEditText.getText().toString();
            String login = usernameEditText.getText().toString();
            if (pass == null || pass.trim().isEmpty() || login == null || login.trim().isEmpty()) {
                return;
            }
            Executors.newSingleThreadExecutor().execute(() -> {
                AuthService.getInstance().signIn(login, pass, false)
                        .subscribe(userDTO -> {
                                    Log.d("Login", "logged in");
                                    new Handler(Looper.getMainLooper()).post(() -> {
                                        updateUiWithUser(userDTO);
                                    });
                                },
                                error -> {
                                    Log.d("Error login", String.valueOf(error));
                                    new Handler(Looper.getMainLooper()).post(() -> showLoginFailed(R.string.login_failed));
                                });
            });
        });
    }

    private void updateUiWithUser(UserDTO model) {
        String welcome = getString(R.string.welcome) + model.getUsername();
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}