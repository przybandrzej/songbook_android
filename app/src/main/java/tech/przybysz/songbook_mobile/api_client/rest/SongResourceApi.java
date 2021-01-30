package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.CreateSongDTO;
import java.io.File;
import tech.przybysz.songbook_mobile.api_client.domain.PlaylistDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UniversalCreateDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserSongRatingDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SongResourceApi {
  /**
   * addTagToSong
   * 
   * @param id id (required)
   * @param tag tag (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/songs/{id}/add-tag")
  Observable<SongDTO> addTagToSongUsingPATCH(
          @Path("id") Long id, @Body UniversalCreateDTO tag
  );

  /**
   * addTagsToSongBulk
   * 
   * @param id id (required)
   * @param tags tags (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/songs/{id}/add-tag-bulk")
  Observable<SongDTO> addTagsToSongBulkUsingPATCH(
          @Path("id") Long id, @Body List<UniversalCreateDTO> tags
  );

  /**
   * approveSong
   * 
   * @param id id (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/songs/{id}/approve")
  Observable<SongDTO> approveSongUsingPUT(
    @Path("id") Long id
  );

  /**
   * create
   * 
   * @param obj obj (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/songs")
  Observable<SongDTO> createUsingPOST4(
    @Body CreateSongDTO obj
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/songs/id/{id}")
  Completable deleteUsingDELETE4(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @param includeAwaiting include_awaiting (optional)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs")
  Observable<List<SongDTO>> getAllUsingGET4(
          @Query("include_awaiting") Boolean includeAwaiting, @Query("limit") Integer limit
  );

  /**
   * getByAuthor
   * 
   * @param authorId authorId (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/author/{authorId}")
  Observable<List<SongDTO>> getByAuthorUsingGET(
          @Path("authorId") Long authorId, @Query("limit") Integer limit
  );

  /**
   * getByCategory
   * 
   * @param categoryId categoryId (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/category/{categoryId}")
  Observable<List<SongDTO>> getByCategoryUsingGET1(
          @Path("categoryId") Long categoryId, @Query("limit") Integer limit
  );

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @GET("api/songs/id/{id}")
  Observable<SongDTO> getByIdUsingGET4(
    @Path("id") Long id
  );

  /**
   * getByLyricsFragment
   * 
   * @param value value (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/lyrics_fragment/{value}")
  Observable<List<SongDTO>> getByLyricsFragmentUsingGET1(
          @Path("value") String value, @Query("limit") Integer limit
  );

  /**
   * getByRating
   * 
   * @param equal equal (optional)
   * @param greaterThanEqual greaterThanEqual (optional)
   * @param lessThanEqual lessThanEqual (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/rating")
  Observable<List<SongDTO>> getByRatingUsingGET(
          @Query("equal") Double equal, @Query("greaterThanEqual") Double greaterThanEqual, @Query("lessThanEqual") Double lessThanEqual
  );

  /**
   * getByTag
   * 
   * @param tagId tagId (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/tag/{tagId}")
  Observable<List<SongDTO>> getByTagUsingGET1(
          @Path("tagId") Long tagId, @Query("limit") Integer limit
  );

  /**
   * getByTitleFragment
   * 
   * @param title title (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/title/{title}")
  Observable<List<SongDTO>> getByTitleFragmentUsingGET1(
          @Path("title") String title, @Query("limit") Integer limit
  );

  /**
   * getLatest
   * 
   * @param limit limit (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/latest")
  Observable<List<SongDTO>> getLatestUsingGET1(
    @Query("limit") Integer limit
  );

  /**
   * getSongPlaylists
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;PlaylistDTO&gt;&gt;
   */
  @GET("api/songs/id/{id}/playlists")
  Observable<List<PlaylistDTO>> getSongPlaylistsUsingGET(
    @Path("id") Long id
  );

  /**
   * getSongRatings
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;UserSongRatingDTO&gt;&gt;
   */
  @GET("api/songs/id/{id}/ratings")
  Observable<List<UserSongRatingDTO>> getSongRatingsUsingGET(
    @Path("id") Long id
  );

  /**
   * getSongUserLibraries
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;UserDTO&gt;&gt;
   */
  @GET("api/songs/id/{id}/users")
  Observable<List<UserDTO>> getSongUserLibrariesUsingGET(
    @Path("id") Long id
  );

  /**
   * getSongsAddedByUser
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/user/{id}/added")
  Observable<List<SongDTO>> getSongsAddedByUserUsingGET(
    @Path("id") Long id
  );

  /**
   * getSongsEditedByUser
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/user/{id}/edited")
  Observable<List<SongDTO>> getSongsEditedByUserUsingGET(
    @Path("id") Long id
  );

  /**
   * getUserSongs
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/songs/user/{id}")
  Observable<List<SongDTO>> getUserSongsUsingGET(
    @Path("id") Long id
  );

  /**
   * loadFromFile
   * 
   * @param file file (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Multipart
  @POST("api/songs/upload")
  Observable<SongDTO> loadFromFileUsingPOST(
    @Part MultipartBody.Part file
  );

  /**
   * removeTagFromSong
   * 
   * @param id id (required)
   * @param tagId tagId (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/songs/{id}/remove-tag/{tagId}")
  Observable<SongDTO> removeTagFromSongUsingPATCH(
          @Path("id") Long id, @Path("tagId") Long tagId
  );

  /**
   * removeTagsFromSongBulk
   * 
   * @param id id (required)
   * @param tagIds tagIds (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/songs/{id}/remove-tag-bulk/{tagIds}")
  Observable<SongDTO> removeTagsFromSongBulkUsingPATCH(
          @Path("id") Long id, @Path("tagIds") String tagIds
  );

  /**
   * update
   * 
   * @param obj obj (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/songs")
  Observable<SongDTO> updateUsingPUT4(
    @Body SongDTO obj
  );

}
