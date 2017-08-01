package io.bucare.www.kotlintutorial.analytics;

import android.support.annotation.NonNull;

public interface Analytics {
  void send(@NonNull String tag);
}
