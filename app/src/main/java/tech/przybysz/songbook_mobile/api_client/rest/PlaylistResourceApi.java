package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.CreatePlaylistDTO;
import tech.przybysz.songbook_mobile.api_client.domain.PlaylistDTO;
import tech.przybysz.songbook_mobile.api_client.domain.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PlaylistResourceApi {
  /**
   * addSong
   * 
   * @param id id (required)
   * @param songId songId (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/playlists/{id}/add-song/{songId}")
  Completable addSongUsingPATCH(
          @Path("id") Long id, @Path("songId") Long songId
  );

  /**
   * create
   * 
   * @param dto dto (required)
   * @return Observable&lt;PlaylistDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/playlists")
  Observable<PlaylistDTO> createUsingPOST2(
    @Body CreatePlaylistDTO dto
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/playlists/id/{id}")
  Completable deleteUsingDELETE2(
    @Path("id") Long id
  );

  /**
   * downloadPlaylistPdfSongbook
   * 
   * @param id id (required)
   * @return Observable&lt;Resource&gt;
   */
  @GET("api/playlists/download/{id}")
  Observable<Resource> downloadPlaylistPdfSongbookUsingGET(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @param includePrivate include_private (optional, default to false)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;PlaylistDTO&gt;&gt;
   */
  @GET("api/playlists")
  Observable<List<PlaylistDTO>> getAllUsingGET3(
          @Query("include_private") Boolean includePrivate, @Query("limit") Integer limit
  );

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;PlaylistDTO&gt;
   */
  @GET("api/playlists/id/{id}")
  Observable<PlaylistDTO> getByIdUsingGET3(
    @Path("id") Long id
  );

  /**
   * getByName
   * 
   * @param name name (required)
   * @param includePrivate include_private (optional, default to false)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;PlaylistDTO&gt;&gt;
   */
  @GET("api/playlists/name/{name}")
  Observable<List<PlaylistDTO>> getByNameUsingGET1(
          @Path("name") String name, @Query("include_private") Boolean includePrivate, @Query("limit") Integer limit
  );

  /**
   * getByOwnerId
   * 
   * @param id id (required)
   * @param includePrivate include_private (optional, default to false)
   * @return Observable&lt;List&lt;PlaylistDTO&gt;&gt;
   */
  @GET("api/playlists/ownerId/{id}")
  Observable<List<PlaylistDTO>> getByOwnerIdUsingGET(
          @Path("id") Long id, @Query("include_private") Boolean includePrivate
  );

  /**
   * removeSong
   * 
   * @param id id (required)
   * @param songId songId (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/playlists/{id}/remove-song/{songId}")
  Completable removeSongUsingPATCH(
          @Path("id") Long id, @Path("songId") Long songId
  );

  /**
   * update
   * 
   * @param dto dto (required)
   * @return Observable&lt;PlaylistDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/playlists")
  Observable<PlaylistDTO> updateUsingPUT2(
    @Body PlaylistDTO dto
  );

}
