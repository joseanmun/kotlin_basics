package io.bucare.www.kotlintutorial.injection.component;

import android.app.Activity;
import dagger.Component;
import io.bucare.www.kotlintutorial.injection.PerActivity;
import io.bucare.www.kotlintutorial.injection.module.ActivityModule;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  Activity getActivity();
}
