package com.yeho.hero.data.remote;

import com.yeho.hero.data.remote.model.HeroResp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author yeho
 * fecha: 10/07/2018
 * Interface which contains the whole API connections.
 */

public interface ApiClient {

  /**
   * Envia solicitud para obtener Personajes
   */
 // @Headers("Accept-Encoding:gzip")
  @GET(ApiConfiguration.URL_OBTEN_CARACTERES)
  Call<HeroResp> callCharacters(@Query("apikey") String apikey, @Query("ts") String timeStamp, @Query("hash") String hash, @Query("limit") String limit );



}
