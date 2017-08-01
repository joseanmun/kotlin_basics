package io.bucare.www.kotlintutorial.injection.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.bucare.www.kotlintutorial.AndroidApplication;
import io.bucare.www.kotlintutorial.OkHttpClientFactory;
import io.bucare.www.kotlintutorial.analytics.Analytics;
import io.bucare.www.kotlintutorial.analytics.AnalyticsImpl;
import io.bucare.www.kotlintutorial.domain.executor.Executor;
import io.bucare.www.kotlintutorial.domain.executor.MainThread;
import io.bucare.www.kotlintutorial.domain.executor.impl.ThreadExecutor;
import io.bucare.www.kotlintutorial.threading.MainThreadImpl;
import io.bucare.www.kotlintutorial.utils.LoggingProvider;
import io.bucare.www.kotlintutorial.utils.LoggingProviderImpl;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

@Module public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideContext() {
    return application;
  }

  /**
   * THREADING
   */
  @Provides @Singleton Executor provideExecutor(ThreadExecutor threadExecutor) {
    return threadExecutor;
  }

  @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
    return mainThread;
  }

  @Provides @Singleton LoggingProvider providesLogger() {
    return new LoggingProviderImpl();
  }

  @Provides @Singleton OkHttpClient.Builder provideOkHttpClient(Context context,
                                                                LoggingProvider loggingProvider) {
    return new OkHttpClientFactory(context,
                                   loggingProvider).getOkHttpClientBuilder();
  }

  @Provides @Singleton Analytics provideAnalytics(Context context,
                                                  LoggingProvider loggingProvider) {
    return new AnalyticsImpl(context,
                             loggingProvider);
  }
}
