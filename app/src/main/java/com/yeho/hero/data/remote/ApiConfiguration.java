package com.yeho.hero.data.remote;

import java.util.concurrent.TimeUnit;

/**
 * Created by yeho on 10/07/2018
 */

public class ApiConfiguration {
  //Time out
  public static final int TIME_OUT = 18;
  public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

  //Base URLs
  public static final String BASE_URL_PROD = "http://gateway.marvel.com";


  //API URLs
  public static final String URL_OBTEN_CARACTERES =  "/v1/public/characters";


}
