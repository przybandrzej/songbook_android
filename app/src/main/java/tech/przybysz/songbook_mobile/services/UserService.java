package tech.przybysz.songbook_mobile.services;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import io.reactivex.Observable;
import tech.przybysz.songbook_mobile.api_client.domain.PlaylistDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserRoleDTO;
import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.api_client.rest.SongResourceApi;
import tech.przybysz.songbook_mobile.api_client.rest.UserResourceApi;
import tech.przybysz.songbook_mobile.api_client.rest.UserRoleResourceApi;

public class UserService {

    private static UserService Instance;

    public static UserService getInstance() {
        if (Instance == null) {
            Instance = new UserService();
        }
        return Instance;
    }

    private UserService() {
        this.authService = AuthService.getInstance();
        this.api = ApiClient.getInstance().createService(UserResourceApi.class);
        this.songApi = ApiClient.getInstance().createService(SongResourceApi.class);
        this.roleApi = ApiClient.getInstance().createService(UserRoleResourceApi.class);
    }

    private final UserResourceApi api;
    private final AuthService authService;
    private final SongResourceApi songApi;
    private final UserRoleResourceApi roleApi;

    public void getRole(long roleId, Consumer<UserRoleDTO> callback) {
        Executors.newSingleThreadExecutor().execute(() ->
                callback.accept(roleApi.getByIdUsingGET7(roleId).blockingFirst()));
    }

    public void getAdds(long userId, Consumer<List<SongDTO>> callback) {
        Executors.newSingleThreadExecutor().execute(() ->
                callback.accept(songApi.getSongsAddedByUserUsingGET(userId).blockingFirst()));
    }

    public void getEdits(long userId, Consumer<List<SongDTO>> callback) {
        Executors.newSingleThreadExecutor().execute(() ->
                callback.accept(songApi.getSongsEditedByUserUsingGET(userId).blockingFirst()));
    }

    public List<SongDTO> getEdits(long userId) {
        return songApi.getSongsEditedByUserUsingGET(userId).blockingFirst();
    }

    public List<SongDTO> getAdds(long userId) {
        return songApi.getSongsAddedByUserUsingGET(userId).blockingFirst();
    }

    public UserRoleDTO getRole(long roleId) {
        return roleApi.getByIdUsingGET7(roleId).blockingFirst();
    }

    public Observable<List<PlaylistDTO>> getPlaylists(long user) {
        return api.getPlaylistsByUserIdUsingGET(user);
    }
}
