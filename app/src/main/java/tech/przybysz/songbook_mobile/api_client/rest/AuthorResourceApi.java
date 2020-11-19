package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.AuthorDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UniversalCreateDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AuthorResourceApi {
  /**
   * create
   * 
   * @param authorDto authorDto (required)
   * @return Observable&lt;AuthorDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/authors")
  Observable<AuthorDTO> createUsingPOST(
    @Body UniversalCreateDTO authorDto
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/authors/id/{id}")
  Completable deleteUsingDELETE(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;AuthorDTO&gt;&gt;
   */
  @GET("api/authors")
  Observable<List<AuthorDTO>> getAllUsingGET(
    @Query("limit") Integer limit
  );

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;AuthorDTO&gt;
   */
  @GET("api/authors/id/{id}")
  Observable<AuthorDTO> getByIdUsingGET(
    @Path("id") Long id
  );

  /**
   * getByNameFragment
   * 
   * @param name name (required)
   * @param limit limit (optional)
   * @return Observable&lt;List&lt;AuthorDTO&gt;&gt;
   */
  @GET("api/authors/name/{name}")
  Observable<List<AuthorDTO>> getByNameFragmentUsingGET(
          @Path("name") String name, @Query("limit") Integer limit
  );

  /**
   * getSongsByAuthorId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongDTO&gt;&gt;
   * @deprecated
   */
  @Deprecated
  @GET("api/authors/id/{id}/songs")
  Observable<List<SongDTO>> getSongsByAuthorIdUsingGET(
    @Path("id") Long id
  );

  /**
   * update
   * 
   * @param authorDto authorDto (required)
   * @return Observable&lt;AuthorDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/authors")
  Observable<AuthorDTO> updateUsingPUT(
    @Body AuthorDTO authorDto
  );

}
