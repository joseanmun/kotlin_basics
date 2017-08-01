package io.bucare.www.kotlintutorial.network.core;

import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by jofre on 13/07/16.
 */
@Singleton public class RestClient {
  protected Retrofit retrofit;

  public <T> T getService(Class<T> serviceClass) {
    return retrofit.create(serviceClass);
  }
}
