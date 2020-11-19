package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.UniversalCreateDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserRoleDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserRoleResourceApi {
  /**
   * create
   * 
   * @param userRoleDto userRoleDto (required)
   * @return Observable&lt;UserRoleDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/user_roles")
  Observable<UserRoleDTO> createUsingPOST6(
    @Body UniversalCreateDTO userRoleDto
  );

  /**
   * delete
   * 
   * @param id id (required)
   * @return Completable
   */
  @DELETE("api/user_roles/id/{id}")
  Completable deleteUsingDELETE7(
    @Path("id") Long id
  );

  /**
   * getAll
   * 
   * @return Observable&lt;List&lt;UserRoleDTO&gt;&gt;
   */
  @GET("api/user_roles")
  Observable<List<UserRoleDTO>> getAllUsingGET7();
    

  /**
   * getById
   * 
   * @param id id (required)
   * @return Observable&lt;UserRoleDTO&gt;
   */
  @GET("api/user_roles/id/{id}")
  Observable<UserRoleDTO> getByIdUsingGET7(
    @Path("id") Long id
  );

  /**
   * getByNameSearchQuery
   * 
   * @param searchQuery searchQuery (required)
   * @return Observable&lt;List&lt;UserRoleDTO&gt;&gt;
   */
  @GET("api/user_roles/name/{searchQuery}")
  Observable<List<UserRoleDTO>> getByNameSearchQueryUsingGET(
    @Path("searchQuery") String searchQuery
  );

  /**
   * getUsersByUserRoleId
   * 
   * @param id id (required)
   * @return Observable&lt;List&lt;UserDTO&gt;&gt;
   * @deprecated
   */
  @Deprecated
  @GET("api/user_roles/id/{id}/users")
  Observable<List<UserDTO>> getUsersByUserRoleIdUsingGET(
    @Path("id") Long id
  );

  /**
   * update
   * 
   * @param userRoleDto userRoleDto (required)
   * @return Observable&lt;UserRoleDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/user_roles")
  Observable<UserRoleDTO> updateUsingPUT6(
    @Body UserRoleDTO userRoleDto
  );

}
