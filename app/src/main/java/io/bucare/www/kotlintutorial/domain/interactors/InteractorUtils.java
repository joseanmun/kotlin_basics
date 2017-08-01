package io.bucare.www.kotlintutorial.domain.interactors;

import io.bucare.www.kotlintutorial.domain.interactors.base.Interactor;

public class InteractorUtils {
  public static void cancelInteractorIfNeeded(Interactor interactor) {
    if (null != interactor && interactor.isRunning()) {
      interactor.cancel();
    }
  }
}
