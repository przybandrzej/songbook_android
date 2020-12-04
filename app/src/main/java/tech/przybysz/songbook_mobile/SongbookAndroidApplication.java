package tech.przybysz.songbook_mobile;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.services.PreferenceService;
import tech.przybysz.songbook_mobile.services.network.HttpInterceptor;

public class SongbookAndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initApp();
    }

    private void initApp() {
        // set url for API from environment
        ArrayList<Interceptor> interceptors = new ArrayList<>(2);
        interceptors.add(new HttpInterceptor());
        ApiClient.init(HttpLoggingInterceptor.Level.BODY, interceptors);
        //ApiClient.getInstance().setBaseUrl("http://localhost:8080");
        PreferenceService.init(getApplicationContext());
    }
}
