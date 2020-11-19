package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.SongCoauthorDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SongCoauthorResourceApi {
  /**
   * create
   * 
   * @param songCoauthorDTO songCoauthorDTO (required)
   * @return Observable&lt;SongCoauthorDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/coauthors")
  Observable<SongCoauthorDTO> createUsingPOST3(
    @Body SongCoauthorDTO songCoauthorDTO
  );

  /**
   * delete
   * 
   * @param authorId authorId (required)
   * @param function function (required)
   * @param songId songId (required)
   * @return Completable
   */
  @DELETE("api/coauthors/{songId}/{authorId}/{function}")
  Completable deleteUsingDELETE3(
          @Path("authorId") Long authorId, @Path("function") String function, @Path("songId") Long songId
  );

  /**
   * getByAuthorId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongCoauthorDTO&gt;&gt;
   */
  @GET("api/coauthors/author/{id}")
  Observable<List<SongCoauthorDTO>> getByAuthorIdUsingGET(
    @Path("id") Long id
  );

  /**
   * getByFunction
   * 
   * @param function function (required)
   * @return Observable&lt;List&lt;SongCoauthorDTO&gt;&gt;
   */
  @GET("api/coauthors/function/{function}")
  Observable<List<SongCoauthorDTO>> getByFunctionUsingGET(
    @Path("function") String function
  );

  /**
   * getBySongId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;SongCoauthorDTO&gt;&gt;
   */
  @GET("api/coauthors/song/{id}")
  Observable<List<SongCoauthorDTO>> getBySongIdUsingGET(
    @Path("id") Long id
  );

  /**
   * update
   * 
   * @param songCoauthorDTO songCoauthorDTO (required)
   * @return Observable&lt;SongCoauthorDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/coauthors")
  Observable<SongCoauthorDTO> updateUsingPUT3(
    @Body SongCoauthorDTO songCoauthorDTO
  );

}
