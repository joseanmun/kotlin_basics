package io.bucare.www.kotlintutorial.injection.component;

import dagger.Component;
import io.bucare.www.kotlintutorial.injection.PerActivity;
import io.bucare.www.kotlintutorial.injection.module.ActivityModule;
import io.bucare.www.kotlintutorial.injection.module.UserModule;
import io.bucare.www.kotlintutorial.presentation.ui.SplashActivity;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, UserModule.class
}) public interface UserComponent {
  void inject(SplashActivity splashActivity);
}
