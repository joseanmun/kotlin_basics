package io.bucare.www.kotlintutorial;

import android.content.Context;
import io.bucare.www.kotlintutorial.network.core.LoggingInterceptor;
import io.bucare.www.kotlintutorial.utils.LoggingProvider;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

/**
 * Created by jofre on 30/06/16.
 */
@Singleton public class OkHttpClientFactory {
  Context context;
  LoggingProvider loggingProvider;

  public OkHttpClientFactory(Context context, LoggingProvider loggingProvider) {
    this.loggingProvider = loggingProvider;
    this.context = context;
  }

  public OkHttpClient.Builder getOkHttpClientBuilder() {
    return new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor(loggingProvider));
  }
}
