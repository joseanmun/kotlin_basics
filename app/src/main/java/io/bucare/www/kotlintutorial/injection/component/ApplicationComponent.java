package io.bucare.www.kotlintutorial.injection.component;

import android.content.Context;
import dagger.Component;
import io.bucare.www.kotlintutorial.analytics.Analytics;
import io.bucare.www.kotlintutorial.domain.executor.Executor;
import io.bucare.www.kotlintutorial.domain.executor.MainThread;
import io.bucare.www.kotlintutorial.injection.module.ApplicationModule;
import io.bucare.www.kotlintutorial.presentation.ui.base.BaseActivity;
import io.bucare.www.kotlintutorial.utils.LoggingProvider;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);
  // Threading
  Executor getExecutor();
  MainThread getMainThread();
  LoggingProvider getLogger();
  Context getContext();
  OkHttpClient.Builder getOkHttpClient();
  Analytics analytics();
}
