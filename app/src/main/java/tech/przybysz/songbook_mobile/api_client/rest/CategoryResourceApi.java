package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.CategoryDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UniversalCreateDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CategoryResourceApi {
  /**
   * create
   * 
   * @param categoryDto categoryDto (required)
   * @return Observable&lt;CategoryDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/categories")
  Observable<CategoryDTO> createUsingPOST1(
    @Body UniversalCreateDTO categoryDto
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/categories/id/{id}")
  Completable deleteUsingDELETE1(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @return Observable&lt;List&lt;CategoryDTO&gt;&gt;
   */
  @GET("api/categories")
  Observable<List<CategoryDTO>> getAllUsingGET2();
    

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;CategoryDTO&gt;
   */
  @GET("api/categories/id/{id}")
  Observable<CategoryDTO> getByIdUsingGET2(
    @Path("id") Long id
  );

  /**
   * getByName
   * 
   * @param name name (required)
   * @return Observable&lt;List&lt;CategoryDTO&gt;&gt;
   */
  @GET("api/categories/name/{name}")
  Observable<List<CategoryDTO>> getByNameUsingGET(
    @Path("name") String name
  );

  /**
   * getSongsByCategoryId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   * @deprecated
   */
  @Deprecated
  @GET("api/categories/id/{id}/songs")
  Observable<List<SongDTO>> getSongsByCategoryIdUsingGET(
    @Path("id") Long id
  );

  /**
   * update
   * 
   * @param categoryDto categoryDto (required)
   * @return Observable&lt;CategoryDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/categories")
  Observable<CategoryDTO> updateUsingPUT1(
    @Body CategoryDTO categoryDto
  );

}
