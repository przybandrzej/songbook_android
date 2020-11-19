package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.TagDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UniversalCreateDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TagResourceApi {
  /**
   * create
   * 
   * @param tagDto tagDto (required)
   * @return Observable&lt;TagDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/tags")
  Observable<TagDTO> createUsingPOST5(
    @Body UniversalCreateDTO tagDto
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/tags/id/{id}")
  Completable deleteUsingDELETE5(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;TagDTO&gt;&gt;
   */
  @GET("api/tags")
  Observable<List<TagDTO>> getAllUsingGET5(
    @Query("limit") Integer limit
  );

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;TagDTO&gt;
   */
  @GET("api/tags/id/{id}")
  Observable<TagDTO> getByIdUsingGET5(
    @Path("id") Long id
  );

  /**
   * getByName
   * 
   * @param name name (required)
   * @return Observable&lt;List&lt;TagDTO&gt;&gt;
   */
  @GET("api/tags/name/{name}")
  Observable<List<TagDTO>> getByNameUsingGET2(
    @Path("name") String name
  );

  /**
   * getSongsByTagId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   * @deprecated
   */
  @Deprecated
  @GET("api/tags/id/{id}/songs")
  Observable<List<SongDTO>> getSongsByTagIdUsingGET(
    @Path("id") Long id
  );

  /**
   * update
   * 
   * @param tagDto tagDto (required)
   * @return Observable&lt;TagDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/tags")
  Observable<TagDTO> updateUsingPUT5(
    @Body TagDTO tagDto
  );

}
