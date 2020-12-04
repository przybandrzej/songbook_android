package tech.przybysz.songbook_mobile;

import android.app.Application;
import android.util.Log;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.api_client.invoker.auth.OAuth;
import tech.przybysz.songbook_mobile.services.PreferenceService;
import tech.przybysz.songbook_mobile.services.network.HttpInterceptor;

public class SongbookAndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initApp();
    }

    private void initApp() {
        ApiClient.getInstance()
                .setLoggingLevel(HttpLoggingInterceptor.Level.BODY)
                .addAuthorization("interceptor", new HttpInterceptor())
                .setLocalDateFormat(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneId.of("Z")));
        //.setBaseUrl();
        PreferenceService.init(getApplicationContext());
    }
}
