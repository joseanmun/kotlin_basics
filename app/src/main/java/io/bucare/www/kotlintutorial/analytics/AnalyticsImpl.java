package io.bucare.www.kotlintutorial.analytics;

import android.content.Context;
import android.support.annotation.NonNull;
import io.bucare.www.kotlintutorial.utils.LoggingProvider;

public class AnalyticsImpl implements Analytics {
  private final Context context;
  private final LoggingProvider loggingProvider;

  public AnalyticsImpl(Context context, LoggingProvider loggingProvider) {
    this.context = context;
    this.loggingProvider = loggingProvider;
  }

  @Override public void send(@NonNull String tag) {

  }
}