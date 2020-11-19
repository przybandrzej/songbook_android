package tech.przybysz.songbook_mobile.api_client.rest;

import tech.przybysz.songbook_mobile.api_client.invoker.CollectionFormats.*;

import io.reactivex.Observable;
import io.reactivex.Completable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import tech.przybysz.songbook_mobile.api_client.domain.EmailChangeDTO;
import tech.przybysz.songbook_mobile.api_client.domain.LoginForm;
import tech.przybysz.songbook_mobile.api_client.domain.PasswordChangeDTO;
import tech.przybysz.songbook_mobile.api_client.domain.RegisterNewUserForm;
import tech.przybysz.songbook_mobile.api_client.domain.TokenAndPasswordDTO;
import tech.przybysz.songbook_mobile.api_client.domain.TokenDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AuthenticationResourceApi {
  /**
   * activateAccount
   * 
   * @param key key (required)
   * @return Completable
   */
  @GET("api/activate")
  Completable activateAccountUsingGET(
    @Query("key") String key
  );

  /**
   * authenticate
   * 
   * @param form form (required)
   * @return Observable&lt;TokenDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/authenticate")
  Observable<TokenDTO> authenticateUsingPOST(
    @Body LoginForm form
  );

  /**
   * changeEmail
   * 
   * @param emailChangeDTO emailChangeDTO (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/account/change-email")
  Completable changeEmailUsingPATCH(
    @Body EmailChangeDTO emailChangeDTO
  );

  /**
   * changePassword
   * 
   * @param passwordChangeDto passwordChangeDto (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/account/change-password")
  Completable changePasswordUsingPOST(
    @Body PasswordChangeDTO passwordChangeDto
  );

  /**
   * finishPasswordReset
   * 
   * @param keyAndPassword keyAndPassword (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/account/reset-password/finish")
  Completable finishPasswordResetUsingPOST(
    @Body TokenAndPasswordDTO keyAndPassword
  );

  /**
   * getAccount
   * 
   * @return Observable&lt;UserDTO&gt;
   */
  @GET("api/account")
  Observable<UserDTO> getAccountUsingGET();
    

  /**
   * isAuthenticated
   * 
   * @return Observable&lt;Boolean&gt;
   */
  @GET("api/is-authenticated")
  Observable<Boolean> isAuthenticatedUsingGET();
    

  /**
   * register
   * 
   * @param form form (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/register")
  Completable registerUsingPOST(
    @Body RegisterNewUserForm form
  );

  /**
   * requestPasswordReset
   * 
   * @param mail mail (required)
   * @return Completable
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/account/reset-password/init")
  Completable requestPasswordResetUsingPOST(
    @Body String mail
  );

  /**
   * saveAccount
   * 
   * @param userDTO userDTO (required)
   * @return Observable&lt;UserDTO&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/account")
  Observable<UserDTO> saveAccountUsingPOST(
    @Body UserDTO userDTO
  );

}
