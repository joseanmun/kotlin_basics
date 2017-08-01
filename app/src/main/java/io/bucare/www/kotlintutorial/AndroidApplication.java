package io.bucare.www.kotlintutorial;

import android.app.Application;
import android.util.Log;
import io.bucare.www.kotlintutorial.injection.component.ApplicationComponent;
import io.bucare.www.kotlintutorial.injection.component.DaggerApplicationComponent;
import io.bucare.www.kotlintutorial.injection.module.ApplicationModule;
import io.bucare.www.kotlintutorial.utils.FontsOverride;

public class AndroidApplication extends Application {
  public static final String TAG = "AndroidApplication";
  private ApplicationComponent component;

  @Override public void onCreate() {
    super.onCreate();
    //Todo: Fabric Integration
    /*if (!BuildConfig.DEBUG) {
      Fabric.with(this,
                  new Crashlytics());
    }*/

    initializeInjector();
    setCustomFonts();
  }

  private void setCustomFonts() {
    try {
      FontsOverride.overrideNormalFonts(this,
                                        "SourceSansPro-Light.ttf",
                                        "SourceSansPro-Italic.ttf",
                                        "SourceSansPro-Semibold.ttf",
                                        "SourceSansPro-SemiboldItalic.ttf");
      Log.d(TAG,
            "setCustomFonts: normal fonts override correctly");
    } catch (IllegalAccessException e) {
      Log.e(TAG,
            e.getMessage(),
            e.getCause());
    }
  }

  private void initializeInjector() {
    component = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getComponent() {
    return component;
  }
}
