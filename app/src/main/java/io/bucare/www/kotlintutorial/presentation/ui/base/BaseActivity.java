package io.bucare.www.kotlintutorial.presentation.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.bucare.www.kotlintutorial.AndroidApplication;
import io.bucare.www.kotlintutorial.injection.component.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initializeInjector(getApplicationComponent());
  }

  /**
   * Get the Main Application component for dependency injection.
   *
   * @return {@link ApplicationComponent}
   */
  public ApplicationComponent getApplicationComponent() {
    return ((AndroidApplication) getApplication()).getComponent();
  }

  /**
   * Initialize injections by field.
   *
   * @param applicationComponent {@link ApplicationComponent} main component.
   */
  protected abstract void initializeInjector(ApplicationComponent applicationComponent);
}
