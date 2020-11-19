package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.PlaylistDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserSongRatingDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserResourceApi {
  /**
   * addSongToLibrary
   * 
   * @param id id (required)
   * @param songId songId (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/users/{id}/add-song/{songId}")
  Completable addSongToLibraryUsingPATCH(
          @Path("id") Long id, @Path("songId") Long songId
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/users/id/{id}")
  Completable deleteUsingDELETE6(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;UserDTO&gt;&gt;
   */
  @GET("api/users")
  Observable<List<UserDTO>> getAllUsingGET6(
    @Query("limit") Integer limit
  );

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;UserDTO&gt;
   */
  @GET("api/users/id/{id}")
  Observable<UserDTO> getByIdUsingGET6(
    @Path("id") Long id
  );

  /**
   * getPlaylistsByUserId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;PlaylistDTO&gt;&gt;
   */
  @GET("api/users/id/{id}/playlists")
  Observable<List<PlaylistDTO>> getPlaylistsByUserIdUsingGET(
    @Path("id") Long id
  );

  /**
   * getRatingsByUserId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;UserSongRatingDTO&gt;&gt;
   */
  @GET("api/users/id/{id}/ratings")
  Observable<List<UserSongRatingDTO>> getRatingsByUserIdUsingGET(
    @Path("id") Long id
  );

  /**
   * removeSongFromLibrary
   * 
   * @param id id (required)
   * @param songId songId (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/users/{id}/remove-song/{songId}")
  Completable removeSongFromLibraryUsingPATCH(
          @Path("id") Long id, @Path("songId") Long songId
  );

}
