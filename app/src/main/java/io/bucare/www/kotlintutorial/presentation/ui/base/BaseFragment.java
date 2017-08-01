package io.bucare.www.kotlintutorial.presentation.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import io.bucare.www.kotlintutorial.R;

public abstract class BaseFragment extends Fragment {
  protected final View.OnClickListener onNavigationBackClickListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      getActivity().onBackPressed();
    }
  };

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializePresenter();
  }

  public void showLoginScreen() {
    getActivity().finish();
  }

  public void showSessionExpiredMessage() {
    Toast.makeText(getActivity(),
                   R.string.session_expired,
                   Toast.LENGTH_SHORT)
        .show();
  }

  protected abstract void initializePresenter();
}
