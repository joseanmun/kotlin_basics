package io.bucare.www.kotlintutorial.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import io.bucare.www.kotlintutorial.analytics.Analytics;
import io.bucare.www.kotlintutorial.injection.component.ApplicationComponent;
import io.bucare.www.kotlintutorial.injection.component.DaggerUserComponent;
import io.bucare.www.kotlintutorial.injection.module.ActivityModule;
import io.bucare.www.kotlintutorial.injection.module.UserModule;
import io.bucare.www.kotlintutorial.presentation.ui.base.BaseActivity;
import javax.inject.Inject;

/**
 * Created by joseanmun on 3/2/17.
 */
public class SplashActivity extends BaseActivity {
  @Inject Analytics analytics;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = new Intent(this,
                               MainActivity.class);
    startActivity(intent);
    finish();
  }

  @Override protected void initializeInjector(ApplicationComponent applicationComponent) {
    DaggerUserComponent.builder()
        .applicationComponent(applicationComponent)
        .activityModule(new ActivityModule(this))
        .userModule(new UserModule())
        .build()
        .inject(this);
  }
}