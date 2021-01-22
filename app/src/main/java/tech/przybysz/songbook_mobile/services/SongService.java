package tech.przybysz.songbook_mobile.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserSongRatingDTO;
import tech.przybysz.songbook_mobile.api_client.invoker.ApiClient;
import tech.przybysz.songbook_mobile.api_client.rest.AuthorResourceApi;
import tech.przybysz.songbook_mobile.api_client.rest.SongResourceApi;
import tech.przybysz.songbook_mobile.api_client.rest.UserResourceApi;
import tech.przybysz.songbook_mobile.api_client.rest.UserSongRatingResourceApi;
import tech.przybysz.songbook_mobile.model.Coauthor;
import tech.przybysz.songbook_mobile.model.Song;
import tech.przybysz.songbook_mobile.model.SongAdd;
import tech.przybysz.songbook_mobile.model.SongEdit;

public class SongService {

    private static SongService Instance;

    public static SongService getInstance() {
        if (Instance == null) {
            Instance = new SongService();
        }
        return Instance;
    }

    private SongService() {
        this.authService = AuthService.getInstance();
        this.api = ApiClient.getInstance().createService(SongResourceApi.class);
        this.userApi = ApiClient.getInstance().createService(UserResourceApi.class);
        this.ratingApi = ApiClient.getInstance().createService(UserSongRatingResourceApi.class);
        this.authorApi = ApiClient.getInstance().createService(AuthorResourceApi.class);
    }

    private final SongResourceApi api;
    private final AuthService authService;
    private final UserResourceApi userApi;
    private final UserSongRatingResourceApi ratingApi;
    private final AuthorResourceApi authorApi;

    public Song fromDto(SongDTO dto) {
        Song song = new Song();
        song.setId(dto.getId());
        song.setTitle(dto.getTitle());
        song.setGuitarTabs(dto.getGuitarTabs());
        song.setAverageRating(dto.getAverageRating());
        song.setAwaiting(dto.isIsAwaiting());
        song.setAuthor(dto.getAuthor());
        song.setCategory(dto.getCategory());
        song.setLyrics(dto.getLyrics());
        song.setTags(dto.getTags());
        song.setTrivia(dto.getTrivia());
        SongAdd add = new SongAdd(dto.getAddedBy().getId(), userApi.getByIdUsingGET6(dto.getAddedBy().getAddedBy()).blockingFirst(), song, dto.getAddedBy().getTimestamp());
        song.setSongAdd(add);
        ratingApi.getByUserIdAndSongIdUsingGET(song.getId(), authService.getUser().getId()).blockingSubscribe(res -> {
            song.setUserRating(res.getRating());
        }, err -> {});
        song.setInUserLib(api.getUserSongsUsingGET(authService.getUser().getId()).blockingFirst().stream().anyMatch(it -> it.getId().equals(song.getId())));
        song.setCoauthors(dto.getCoauthors().stream().map(d -> new Coauthor(authorApi.getByIdUsingGET(d.getAuthorId()).blockingFirst(), song, d.getCoauthorFunction())).collect(Collectors.toList()));
        song.setEdits(dto.getEdits().stream().map(d -> new SongEdit(d.getId(), userApi.getByIdUsingGET6(d.getEditedBy()).blockingFirst(), song, d.getTimestamp())).collect(Collectors.toList()));
        return song;
    }

    public Observable<List<SongDTO>> songList() {
        return api.getAllUsingGET4(true, null);
    }

    public void likeSong(Long id) {
        Executors.newSingleThreadExecutor().execute(() -> userApi.addSongToLibraryUsingPATCH(authService.getUser().getId(), id).blockingAwait());
    }

    public void dislikeSong(Long id) {
        Executors.newSingleThreadExecutor().execute(() -> userApi.removeSongFromLibraryUsingPATCH(authService.getUser().getId(), id).blockingAwait());
    }

    public void rateSong(Long id, Float rating) {
        Executors.newSingleThreadExecutor().execute(() -> {
            if (rating == null) {
                ratingApi.deleteUsingDELETE8(id, authService.getUser().getId()).subscribe();
            } else {
                ratingApi.getByUserIdAndSongIdUsingGET(id, authService.getUser().getId()).blockingSubscribe(res -> {
                    res.setRating(BigDecimal.valueOf(rating));
                    ratingApi.updateUsingPUT7(res).blockingSubscribe();
                }, err -> {
                    ratingApi.createUsingPOST7(new UserSongRatingDTO().songId(id).userId(authService.getUser().getId()).rating(BigDecimal.valueOf(rating))).blockingSubscribe();
                });
            }
        });
    }
}
