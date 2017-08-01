package io.bucare.www.kotlintutorial.presentation.ui;

import android.os.Bundle;
import butterknife.ButterKnife;
import io.bucare.www.kotlintutorial.R;
import io.bucare.www.kotlintutorial.injection.component.ApplicationComponent;
import io.bucare.www.kotlintutorial.presentation.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @Override protected void initializeInjector(ApplicationComponent applicationComponent) {
    applicationComponent.inject(this);
  }

  @Override protected void onResume() {
    super.onResume();
  }
}
