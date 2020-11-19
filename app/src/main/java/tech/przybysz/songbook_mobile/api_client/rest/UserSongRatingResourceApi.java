package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import java.math.BigDecimal;
import tech.przybysz.songbook_mobile.api_client.domain.UserSongRatingDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserSongRatingResourceApi {
  /**
   * create
   * 
   * @param dto dto (required)
   * @return Observable&lt;UserSongRatingDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/ratings")
  Observable<UserSongRatingDTO> createUsingPOST7(
    @Body UserSongRatingDTO dto
  );

  /**
   * delete
   * 
   * @param songId songId (required)
   * @param userId userId (required)
   * @return Completable
   */
  @DELETE("api/ratings/{userId}/{songId}")
  Completable deleteUsingDELETE8(
          @Path("songId") Long songId, @Path("userId") Long userId
  );

  /**
   * getAll
   * 
   * @param equal equal (optional)
   * @param greaterThanEqual greaterThanEqual (optional)
   * @param lessThanEqual lessThanEqual (optional)
   * @return Observable&lt;List&lt;UserSongRatingDTO&gt;&gt;
   */
  @GET("api/ratings")
  Observable<List<UserSongRatingDTO>> getAllUsingGET8(
          @Query("equal") BigDecimal equal, @Query("greaterThanEqual") BigDecimal greaterThanEqual, @Query("lessThanEqual") BigDecimal lessThanEqual
  );

  /**
   * getBySongId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;UserSongRatingDTO&gt;&gt;
   */
  @GET("api/ratings/song/{id}")
  Observable<List<UserSongRatingDTO>> getBySongIdUsingGET1(
    @Path("id") Long id
  );

  /**
   * getByUserIdAndSongId
   * 
   * @param songId songId (required)
   * @param userId userId (required)
   * @return Observable&lt;UserSongRatingDTO&gt;
   */
  @GET("api/ratings/{userId}/{songId}")
  Observable<UserSongRatingDTO> getByUserIdAndSongIdUsingGET(
          @Path("songId") Long songId, @Path("userId") Long userId
  );

  /**
   * getByUserId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;UserSongRatingDTO&gt;&gt;
   */
  @GET("api/ratings/user/{id}")
  Observable<List<UserSongRatingDTO>> getByUserIdUsingGET(
    @Path("id") Long id
  );

  /**
   * update
   * 
   * @param dto dto (required)
   * @return Observable&lt;UserSongRatingDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/ratings")
  Observable<UserSongRatingDTO> updateUsingPUT7(
    @Body UserSongRatingDTO dto
  );

}
