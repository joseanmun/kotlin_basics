package io.bucare.www.kotlintutorial.threading;

import android.os.Handler;
import android.os.Looper;
import io.bucare.www.kotlintutorial.domain.executor.MainThread;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This class makes sure that the runnable we provide will be run on the main UI thread.
 */
@Singleton public class MainThreadImpl implements MainThread {
  private Handler mHandler;

  @Inject public MainThreadImpl() {
    mHandler = new Handler(Looper.getMainLooper());
  }

  @Override public void post(Runnable runnable) {
    mHandler.post(runnable);
  }
}
