package tech.przybysz.songbook_mobile.services;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import tech.przybysz.songbook_mobile.api_client.domain.LoginForm;
import tech.przybysz.songbook_mobile.api_client.domain.TokenDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.api_client.rest.AuthenticationResourceApi;
import tech.przybysz.songbook_mobile.api_client.rest.UserResourceApi;

public class AuthService {

    public static final String TOKEN_KEY = "token";

    private static AuthService Instance;

    public static AuthService getInstance() {
        return Instance;
    }

    public static AuthService init() {
        Instance = new AuthService();
        Instance.loggedIn = PreferenceService.getInstance().getItem(TOKEN_KEY) != null;
        return Instance;
    }

    private AuthService() {
        this.api = ApiClient.getInstance().createService(AuthenticationResourceApi.class);
        this.userApi = ApiClient.getInstance().createService(UserResourceApi.class);
    }

    private final AuthenticationResourceApi api;
    private final UserResourceApi userApi;
    private boolean loggedIn = false;
    private UserDTO user;

    public Observable<UserDTO> signIn(String login, String password, boolean rememberMe) {
        return api.authenticateUsingPOST(new LoginForm().login(login).password(password).rememberMe(rememberMe))
                .flatMap(tokenDTO -> {
                    Log.d("FlatMap", "here");
                    PreferenceService.getInstance().setItem(TOKEN_KEY, tokenDTO.getIdToken());
                    this.loggedIn = true;
                    return api.getAccountUsingGET();
                })
                .map(userDto -> {
                    Log.d("Map", "here");
                    this.user = userDto;
                    return this.user;
                });
    }

    public void signOut() {
        PreferenceService.getInstance().removeItem(TOKEN_KEY);
        this.user = null;
        loggedIn = false;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
