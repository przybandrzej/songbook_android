package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AwaitingSongResourceApi {
  /**
   * getAll
   * 
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/awaiting-songs")
  Observable<List<SongDTO>> getAllUsingGET1(
    @Query("limit") Integer limit
  );

  /**
   * getByCategory
   * 
   * @param categoryId categoryId (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/awaiting-songs/category/{categoryId}")
  Observable<List<SongDTO>> getByCategoryUsingGET(
          @Path("categoryId") Long categoryId, @Query("limit") Integer limit
  );

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;SongDTO&gt;
   */
  @GET("api/awaiting-songs/id/{id}")
  Observable<SongDTO> getByIdUsingGET1(
    @Path("id") Long id
  );

  /**
   * getByLyricsFragment
   * 
   * @param value value (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/awaiting-songs/lyrics_fragment/{value}")
  Observable<List<SongDTO>> getByLyricsFragmentUsingGET(
          @Path("value") String value, @Query("limit") Integer limit
  );

  /**
   * getByTag
   * 
   * @param tagId tagId (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/awaiting-songs/tag/{tagId}")
  Observable<List<SongDTO>> getByTagUsingGET(
          @Path("tagId") Long tagId, @Query("limit") Integer limit
  );

  /**
   * getByTitleFragment
   * 
   * @param title title (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/awaiting-songs/title/{title}")
  Observable<List<SongDTO>> getByTitleFragmentUsingGET(
          @Path("title") String title, @Query("limit") Integer limit
  );

  /**
   * getLatest
   * 
   * @param limit limit (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   */
  @GET("api/awaiting-songs/latest")
  Observable<List<SongDTO>> getLatestUsingGET(
    @Query("limit") Integer limit
  );

}
