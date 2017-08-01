package io.bucare.www.kotlintutorial.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class KeyBoardUtils {
  /**
   * Hides the soft keyboard
   */
  public static void hideSoftKeyboard(Activity activity) {
    if (activity.getCurrentFocus() != null) {
      InputMethodManager inputMethodManager =
          (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
      inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus()
                                                     .getWindowToken(),
                                                 0);
    }
  }

  /**
   * Shows the soft keyboard
   */
  public static void showSoftKeyboard(Activity activity, View view) {
    InputMethodManager inputMethodManager =
        (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
    view.requestFocus();
    inputMethodManager.showSoftInput(view,
                                     0);
  }
}
