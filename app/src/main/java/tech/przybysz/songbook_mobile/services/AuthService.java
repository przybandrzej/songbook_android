package tech.przybysz.songbook_mobile.services;

import io.reactivex.Observable;
import tech.przybysz.songbook_mobile.api_client.domain.LoginForm;
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
        String token = PreferenceService.getInstance().getItem(TOKEN_KEY);
        Instance.loggedIn = token != null;
        if(token != null) {
            Instance.api.getAccountUsingGET().blockingSubscribe(res -> Instance.user = res);
        }
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
                    PreferenceService.getInstance().setItem(TOKEN_KEY, tokenDTO.getIdToken());
                    this.loggedIn = true;
                    return api.getAccountUsingGET();
                })
                .map(userDto -> {
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
