package tech.przybysz.songbook_mobile.services.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tech.przybysz.songbook_mobile.services.PreferenceService;

import static tech.przybysz.songbook_mobile.services.AuthService.TOKEN_KEY;

public class HttpInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.d("Interceptor", "intercept");
        String token = PreferenceService.getInstance().getItem(TOKEN_KEY);
        Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0")
                .build();
        return chain.proceed(request);
    }
}
