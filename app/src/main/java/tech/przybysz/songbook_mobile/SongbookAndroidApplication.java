package tech.przybysz.songbook_mobile;

import android.app.Application;

import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.services.PreferenceService;

public class SongbookAndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //ApiClient.getInstance().setBaseUrl();
        PreferenceService.init(getApplicationContext());
    }
}
