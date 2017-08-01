package io.bucare.www.kotlintutorial.utils;

public interface LoggingProvider {
  void init();
  void i(String log, Object... args);
  void d(String log, Object... args);
  void e(String log, Object... args);
  void w(String log, Object... args);
  void v(String log, Object... args);
  void wtf(String log, Object... args);
  void json(String json);
  void xml(String xml);
  void log(int logPriority, String tag, String message, Throwable throwable);
}
