package io.bucare.www.kotlintutorial.injection.module;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import io.bucare.www.kotlintutorial.injection.PerActivity;

@Module public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity Activity provideActivity() {
    return this.activity;
  }
}
