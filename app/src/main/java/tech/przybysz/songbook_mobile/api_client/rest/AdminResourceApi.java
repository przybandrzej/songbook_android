package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminResourceApi {
  /**
   * activateUser
   * 
   * @param userId userId (required)
   * @return Observable&lt;UserDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/admin/activate-user/{userId}")
  Observable<UserDTO> activateUserUsingPATCH(
    @Path("userId") Long userId
  );

  /**
   * updateUserRole
   * 
   * @param roleId roleId (required)
   * @param userId userId (required)
   * @return Observable&lt;UserDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/admin/update-role/{userId}/{roleId}")
  Observable<UserDTO> updateUserRoleUsingPATCH(
          @Path("roleId") Long roleId, @Path("userId") Long userId
  );

  /**
   * updateUser
   * 
   * @param userDTO userDTO (required)
   * @return Observable&lt;UserDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("api/admin/update-user")
  Observable<UserDTO> updateUserUsingPUT(
    @Body UserDTO userDTO
  );

}
