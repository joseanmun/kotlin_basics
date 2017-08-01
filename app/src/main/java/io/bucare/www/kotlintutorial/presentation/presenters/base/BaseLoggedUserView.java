package io.bucare.www.kotlintutorial.presentation.presenters.base;

public interface BaseLoggedUserView extends BaseView {
  void showLoginScreen();
  void showSessionExpiredMessage();
}
