package io.bucare.www.kotlintutorial.injection.module;

import android.support.v4.app.Fragment;
import dagger.Module;

@Module public class UserModule {
  private Fragment fragment;

  public UserModule() {
  }

  public UserModule(Fragment fragment) {
    this.fragment = fragment;
  }
}
